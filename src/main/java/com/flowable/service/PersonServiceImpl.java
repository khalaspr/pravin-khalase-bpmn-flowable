package com.flowable.service;

import com.flowable.model.Person;
import com.flowable.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;
    public Person addPerson(Person p){
        return personRepository.save(p);
    }
}
