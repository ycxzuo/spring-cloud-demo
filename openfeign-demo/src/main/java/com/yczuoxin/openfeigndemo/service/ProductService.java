package com.yczuoxin.openfeigndemo.service;

import com.yczuoxin.openfeigndemo.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("eureka-client")
public interface ProductService {
    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    Product getById(@PathVariable Long id);

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    boolean save(Product product);

}
