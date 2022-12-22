package com.flowable.service;

import org.springframework.stereotype.Service;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Service
public class EventService {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String firstName;

    private String lastName;

    private Date birthDate;

}
