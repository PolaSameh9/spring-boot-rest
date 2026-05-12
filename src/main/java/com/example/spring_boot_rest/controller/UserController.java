package com.example.spring_boot_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot_rest.model.User;
import com.example.spring_boot_rest.service.UserService;



@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PutMapping("register")
    public User register(@RequestBody User user){
        return service.saveUser(user);
    }
}
