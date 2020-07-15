package com.yczuoxin.ribbondemo.controller;

import com.yczuoxin.ribbondemo.bean.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    private final RestTemplate restTemplate;

    public UserController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/user/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(@PathVariable Long id) {
        return restTemplate.getForObject("http://eureka-client" + "/user/" + id, User.class);
    }
}
