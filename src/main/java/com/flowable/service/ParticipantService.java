package com.flowable.service;

import com.flowable.model.Participant;

import java.util.List;

public interface ParticipantService {
    void registerEvent(Participant participant,Long eventId);
    void makePayment();

    List<Participant> getAllParticipants();
}
