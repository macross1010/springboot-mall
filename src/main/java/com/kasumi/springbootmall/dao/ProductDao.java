package com.kasumi.springbootmall.dao;

import com.kasumi.springbootmall.dto.ProductRequest;
import com.kasumi.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);

}
