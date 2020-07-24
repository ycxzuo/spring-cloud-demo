package com.yczuoxin.webcontext.service;

import com.yczuoxin.openfeigndemo.service.ProductService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("eureka-client")
public interface ProductClient extends ProductService {
}
