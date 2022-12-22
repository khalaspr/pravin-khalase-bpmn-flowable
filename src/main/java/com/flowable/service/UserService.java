package com.flowable.service;

import com.flowable.model.Event;
import com.flowable.model.User;

import java.util.List;

public interface UserService {
    void addMember(User user);

    void addEvent(Event event);

    List<User> getAllUsers();

    List<Event> getAllEvents();

}
