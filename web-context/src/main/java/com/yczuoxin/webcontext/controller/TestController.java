package com.yczuoxin.webcontext.controller;

import com.yczuoxin.openfeigndemo.model.Product;
import com.yczuoxin.webcontext.service.ProductClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private final ProductClient productClient;

    public TestController(ProductClient productClient) {
        this.productClient = productClient;
    }

    @GetMapping(value = "/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getById(@PathVariable Long id) {
        return productClient.getById(id);
    }

}
