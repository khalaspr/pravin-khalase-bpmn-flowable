package com.flowable.service;

import com.flowable.model.Event;
import com.flowable.model.User;
import com.flowable.repository.EventRepository;
import com.flowable.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    @Override
    public void addMember(User user) {
        this.userRepository.save(user);
    }

    @Override
    public void addEvent(Event event) {
        this.eventRepository.save(event);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
}
