package com.flowable.service;

import com.flowable.model.Event;
import com.flowable.model.Participant;
import org.flowable.task.api.Task;

import java.util.List;

public interface BPMNService {
    public void startEvent(Participant participant, Event event);
    public void startPaymentEvent(String processId, String status);
    public List<Task> getAllTasks();
}
