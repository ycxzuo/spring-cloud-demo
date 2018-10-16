package com.yczuoxin.consulclient.service.impl;

import com.yczuoxin.consulclient.service.ConsulService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsulServiceImpl implements ConsulService {

    @Override
    public String demo(){
        return "Hello World";
    }
}
