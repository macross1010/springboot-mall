package com.kasumi.springbootmall.dao;

import com.kasumi.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

}
