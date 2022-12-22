package com.flowable.controller;

import com.flowable.model.Event;
import com.flowable.model.User;
import com.flowable.service.EventService;
import com.flowable.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/events")
    public List<Event> getAllEvents(){
        return userService.getAllEvents();
    }

    @PostMapping("/users")
    public String createUser(@RequestBody User user){

        userService.addMember(user);
        return "User created successfully";
    }

    @PostMapping("/events")
    public String createEvent(@RequestBody Event event){
        userService.addEvent(event);
        return "Events added successfully";
    }
}
