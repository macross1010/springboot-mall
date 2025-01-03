package com.kasumi.springbootmall.dto;

import com.kasumi.springbootmall.constant.ProductCategory;

import javax.validation.constraints.NotNull;

public class ProductRequest {

    @NotNull
    private ProductCategory category;
    private String description;
    @NotNull
    private String image_url;
    @NotNull
    private Integer price;
    @NotNull
    private String product_name;
    @NotNull
    private Integer stock;

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
