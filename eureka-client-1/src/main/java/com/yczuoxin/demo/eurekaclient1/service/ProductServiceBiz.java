package com.yczuoxin.demo.eurekaclient1.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yczuoxin.demo.eurekaclient1.entity.ProductEntity;
import com.yczuoxin.demo.eurekaclient1.mapper.ProductDao;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceBiz extends ServiceImpl<ProductDao, ProductEntity> {
}
