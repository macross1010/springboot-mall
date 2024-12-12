package com.kasumi.springbootmall.model;

import com.kasumi.springbootmall.constant.ProductCategory;

import java.util.Date;

public class Product {
    private Integer product_id;
    private ProductCategory category;
    private String description;
    private String image_url;
    private Integer price;
    private String product_name;
    private Integer stock;
    private Date created_date;
    private Date last_modified_date;
    public Integer getProductId() {
        return product_id;
    }

    public void setProductId(Integer product_id) {
        this.product_id = product_id;
    }

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

    public String getImageUrl() {
        return image_url;
    }

    public void setImageUrl(String image_url) {
        this.image_url = image_url;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getProductName() {
        return product_name;
    }

    public void setProductName(String product_name) {
        this.product_name = product_name;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Date getCreatedDate() {
        return created_date;
    }

    public void setCreatedDate(Date created_date) {
        this.created_date = created_date;
    }

    public Date getLastModifiedDate() {
        return last_modified_date;
    }

    public void setLastModifiedDate(Date last_modified_date) {
        this.last_modified_date = last_modified_date;
    }
}
