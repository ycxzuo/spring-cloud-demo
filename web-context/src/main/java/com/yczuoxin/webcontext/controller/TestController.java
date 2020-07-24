package com.yczuoxin.webcontext.controller;

import com.yczuoxin.openfeigndemo.model.Product;
import com.yczuoxin.webcontext.service.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private ProductClient productClient;

    @GetMapping(value = "/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getById(@PathVariable Long id) {
        return productClient.getById(id);
    }

}
