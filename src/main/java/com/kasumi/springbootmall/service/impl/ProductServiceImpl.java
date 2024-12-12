package com.kasumi.springbootmall.service.impl;

import com.kasumi.springbootmall.dao.ProductDao;
import com.kasumi.springbootmall.model.Product;
import com.kasumi.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}
