package com.yczuoxin.demo.eurekaclient2.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yczuoxin.demo.eurekaclient2.entity.ProductEntity;
import com.yczuoxin.demo.eurekaclient2.mapper.ProductDao;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceBiz extends ServiceImpl<ProductDao, ProductEntity> {
}
