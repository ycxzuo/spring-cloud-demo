package com.yczuoxin.demo.eurekaclient1.controller;

import com.yczuoxin.demo.eurekaclient1.entity.ProductEntity;
import com.yczuoxin.demo.eurekaclient1.service.ProductServiceBiz;
import com.yczuoxin.openfeigndemo.model.Product;
import com.yczuoxin.openfeigndemo.service.ProductService;
import org.springframework.stereotype.Controller;

@Controller
public class ProductServiceImpl implements ProductService {

    private ProductServiceBiz productServiceBiz;

    public ProductServiceImpl(ProductServiceBiz productServiceBiz) {
        this.productServiceBiz = productServiceBiz;
    }

    @Override
    public Product getById(Long id) {
        ProductEntity productEntity = productServiceBiz.getById(id);
        Product product = new Product();
        product.setId(productEntity.getId());
        product.setName(productEntity.getName());
        product.setDescription(productEntity.getDescription());
        return product;
    }

    @Override
    public boolean save(Product product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(product.getId());
        productEntity.setName(product.getName());
        productEntity.setDescription(product.getDescription());
        return productServiceBiz.save(productEntity);
    }
}
