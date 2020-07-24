package com.yczuoxin.webcontext.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("eureka-client")
public interface ProductService extends com.yczuoxin.openfeigndemo.service.ProductService {
}
