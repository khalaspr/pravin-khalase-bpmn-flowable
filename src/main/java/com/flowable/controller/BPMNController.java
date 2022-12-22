package com.flowable.controller;

import com.flowable.model.Participant;
import com.flowable.model.Person;
import com.flowable.payloads.TaskRepresentation;
import com.flowable.service.BPMNService;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class BPMNController {

    @Autowired
    private BPMNService bpmnService;

    @Autowired
    private ProcessEngine processEngine;

    @GetMapping("/tasks/all")
    public List<TaskRepresentation> getAll() {
        List<Task> tasks = bpmnService.getAllTasks();
        List<TaskRepresentation> dtos = new ArrayList<TaskRepresentation>();
        TaskService taskService = processEngine.getTaskService();
        for (Task task : tasks) {
            Map<String, Object> processVariables = taskService.getVariables(task.getId());
            dtos.add(new TaskRepresentation(task.getId(), task.getName(),(Participant) processVariables.get("person")));
        }
        return dtos;
    }
}
