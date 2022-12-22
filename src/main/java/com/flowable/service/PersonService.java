package com.flowable.service;

import com.flowable.model.Person;
import org.springframework.stereotype.Service;


public interface PersonService {
    abstract Person addPerson(Person p);
}
