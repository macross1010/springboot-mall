package com.kasumi.springbootmall.rowmapper;

import com.kasumi.springbootmall.constant.ProductCategory;
import com.kasumi.springbootmall.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product = new Product();

        product.setProductId(resultSet.getInt("product_id"));
        product.setProductName(resultSet.getString("product_name"));
        String categoryStr = resultSet.getString("category");
        ProductCategory category = ProductCategory.valueOf(categoryStr);
        product.setCategory(category);
        //product.setCategory(ProductCategory.valueOf(resultSet.getString("category")));
        product.setDescription(resultSet.getString("description"));
        product.setImageUrl(resultSet.getString("image_url"));
        product.setStock(resultSet.getInt("stock"));
        product.setPrice(resultSet.getInt("price"));
        product.setCreatedDate(resultSet.getDate("created_date"));
        product.setLastModifiedDate(resultSet.getDate("last_modified_date"));

        return product;
    }
}
