package com.yczuoxin.webfluxdemo1.controller;

import com.yczuoxin.webfluxdemo1.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    private final DatabaseClient databaseClient;

    public UserController(DatabaseClient databaseClient) {
        this.databaseClient = databaseClient;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<User> getUser(@PathVariable Long id) {
        return databaseClient.execute("select * from user where id = :id")
                .bind("id", id)
                .as(User.class)
                .fetch()
                .one();
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<User> getUsers() {
        return databaseClient.execute("select * from user").as(User.class).fetch().all();
    }

    @GetMapping(value = "/add")
    public Mono<Integer> insert() {
        User user = new User();
        user.setId(3L);
        user.setName("c");
        user.setAge(5);

        return databaseClient.insert().into(User.class)
                .using(user)
                .fetch().rowsUpdated();
    }

}
