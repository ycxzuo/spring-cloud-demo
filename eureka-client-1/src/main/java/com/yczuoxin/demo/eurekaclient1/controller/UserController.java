package com.yczuoxin.demo.eurekaclient1.controller;

import com.yczuoxin.demo.eurekaclient1.entity.User;
import com.yczuoxin.demo.eurekaclient1.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(@PathVariable Long id) {
        System.out.println("client1 被调用了...................");
        //userService.findById(id);
        return userService.getById(id);
    }

}
