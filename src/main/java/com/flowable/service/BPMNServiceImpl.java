package com.flowable.service;

import com.flowable.model.Event;
import com.flowable.model.Participant;
import com.flowable.model.Person;
import org.flowable.engine.HistoryService;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.history.HistoricActivityInstance;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BPMNServiceImpl implements BPMNService {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;
    @Autowired
    private ProcessEngine processEngine;


    @Override
    public void startEvent(Participant participant, Event event) {
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("person", participant);
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("holidayRequest", variables);
        TaskService taskService = processEngine.getTaskService();
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(participant.getId().toString()).list();
        Task lastTaks = tasks.get(tasks.size()-1);
        Map<String, Object> processVariables = taskService.getVariables(lastTaks.getId());
        variables.put("approved", event.isPaid());
        taskService.complete(lastTaks.getId(), variables);
    }

    public List<Task> getAllTasks() {
        return taskService.createTaskQuery().list();
    }

    @Override
    public void startPaymentEvent(String processId, String status) {
        TaskService taskService1 = processEngine.getTaskService();
        List<Task> tasks =  taskService1.createTaskQuery().active().list().stream().filter(t -> t.getId().equals(processId)).collect(Collectors.toList());

        if(tasks.size() > 0 ){
            Task firstTask = tasks.get(0);

            tasks.forEach(s-> System.out.println(s.getId()));
            System.out.println("task"+tasks.size());

            Map<String, Object> processVariables = taskService1.getVariables(firstTask.getId());
            Participant user =(Participant) processVariables.get("person");
            processVariables.put("paymentDone", status.equals("SUCCESS"));
            taskService1.complete(firstTask.getId(), processVariables);

            System.out.println("Completing the payment....");

            HistoryService historyService = processEngine.getHistoryService();
            List<HistoricActivityInstance> activities =
                    historyService.createHistoricActivityInstanceQuery()
                            .processInstanceId(firstTask.getProcessInstanceId())
                            .finished()
                            .orderByHistoricActivityInstanceEndTime().asc()
                            .list();

            System.out.println("activities"+activities.size());

            for (HistoricActivityInstance activity : activities) {
                System.out.println(activity.getActivityId() + " took "
                        + activity.getDurationInMillis() + " milliseconds");
            }

        }
    }
}
