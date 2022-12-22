package com.flowable.controller;

import com.flowable.model.Participant;
import com.flowable.service.BPMNService;
import com.flowable.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Struct;
import java.util.List;

@RestController
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    @Autowired
    private BPMNService bpmnService;

    @PostMapping("/registerEvent/{eventId}")
    public String registerToEvent(@RequestBody Participant participant, @PathVariable Long eventId){
        System.out.println(participant.getFirstName());
        participantService.registerEvent(participant,eventId);
        return "user registerd to event.";
    }

    @PostMapping("/makePayment")
    public String registerToEvent(@RequestParam String processId, @RequestParam String status){
        bpmnService.startPaymentEvent(processId,status);
        return "Registerd to event successfully";
    }


    @PostMapping("/participants")
    public List<Participant> getAllParticipants(){
        return participantService.getAllParticipants();
    }
}
