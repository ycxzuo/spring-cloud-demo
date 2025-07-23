package com.yczuoxin.demo.eurekaclient1.controller;

import com.yczuoxin.openfeigndemo.model.Product;
import com.yczuoxin.openfeigndemo.service.ProductService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductServiceImpl implements ProductService {


    @Override
    public Product getById(Long id) {
        return null;
    }

    @Override
    public boolean save(Product product) {
        return false;
    }
}
