package com.yczuoxin.webcontext.controller;

import com.yczuoxin.openfeigndemo.model.Product;
import com.yczuoxin.webcontext.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.getById(id);
    }

}
