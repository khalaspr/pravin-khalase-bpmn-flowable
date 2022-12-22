package com.flowable.repository;

import com.flowable.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaticipantRepository extends JpaRepository<Participant,Long> {
}
