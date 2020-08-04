package com.yczuoxin.webfluxdemo1.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Log4j2
public class EchoController {

    @GetMapping(value = "/echo/{message}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> echo(@PathVariable String message){
        return Mono.just("hello," + message + "!");
    }

    @GetMapping(value = "/mono")
    public Mono<Object> mono() {
        return Mono.create(monoSink -> {
            log.info("创建 Mono");
            monoSink.success("hello webflux");
        }).doOnSubscribe(subscription -> {
            log.info("subscription：{}", subscription);
        }).doOnNext(o -> {
            log.info("{}", o);
        });
    }

    @GetMapping("/flux")
    public Flux<String> flux() {
        return Flux.just("hello", "webflux", "spring", "boot");
    }

}
