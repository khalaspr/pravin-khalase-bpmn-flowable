package com.flowable.service;

import com.flowable.model.Event;
import com.flowable.model.Participant;
import com.flowable.repository.EventRepository;
import com.flowable.repository.PaticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantServiceImpl implements ParticipantService {

    @Autowired
    private PaticipantRepository paticipantRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private BPMNService bpmnService;
    @Override
    public void registerEvent(Participant participant,Long eventId) {
//        paticipantRepository.save(participant);
        Optional<Event> event = eventRepository.findById(eventId);

        if(event.isPresent()){
            Event e = event.get();
            participant.setEvent(event.get());

            paticipantRepository.save(participant);
            bpmnService.startEvent(participant,e);

        }

    }

    @Override
    public List<Participant> getAllParticipants() {
        return  paticipantRepository.findAll();
    }

    @Override
    public void makePayment() {

    }
}
