package com.kasumi.springbootmall.dao.impl;

import com.kasumi.springbootmall.dao.ProductDao;
import com.kasumi.springbootmall.dto.ProductRequest;
import com.kasumi.springbootmall.model.Product;
import com.kasumi.springbootmall.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public Product getProductById(Integer productId) {

        String sql = "select product_id, product_name, category, image_url, price, stock, description, " +
                "created_date, last_modified_date " +
                "from product where product_id = :productId";
        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        if (productList.size()>0) {
            return productList.get(0);
        }else {
            return null;
        }
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {

        String sql = "INSERT INTO product(product_name, category, image_url, price, stock, " +
                "description, created_date, last_modified_date) " +
                "VALUES (:product_name, :category, :image_url, :price, :stock, " +
                ":description, :createdDate, :lastModifiedDate)";

        Map<String, Object> map = new HashMap<>();
        map.put("product_name", productRequest.getProduct_name());
        map.put("category", productRequest.getCategory().toString());
        map.put("image_url", productRequest.getImage_url());
        map.put("price", productRequest.getPrice());
        map.put("stock", productRequest.getStock());
        map.put("description", productRequest.getDescription());

        Date now = new Date();
        map.put("createdDate", now);
        map.put("lastModifiedDate", now);

        System.out.println(sql);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int productId = keyHolder.getKey().intValue();

        return productId;

    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {

        String sql = "UPDATE product set product_name = :product_name, category = :category, image_url = :image_url, " +
                "price = :price, stock = :stock, description = :description, last_modified_date = :lastModifiedDate " +
                " WHERE product_id = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        map.put("product_name", productRequest.getProduct_name());
        map.put("category", productRequest.getCategory().toString());
        map.put("image_url", productRequest.getImage_url());
        map.put("price", productRequest.getPrice());
        map.put("stock", productRequest.getStock());
        map.put("description", productRequest.getDescription());

        map.put("lastModifiedDate", new Date());

        namedParameterJdbcTemplate.update(sql, map);

    }

    @Override
    public void deleteProductById(Integer productId) {

        String sql = "DELETE FROM product WHERE product_id = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        namedParameterJdbcTemplate.update(sql, map);

    }
}
