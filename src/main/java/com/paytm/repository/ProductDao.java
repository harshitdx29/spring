package com.paytm.repository;

import com.paytm.domain.Product;

import java.util.List;

/**
 * Created by harshitgupta on 4/4/17.
 */
public interface ProductDao {
    public List<Product> getProductList();
    public void saveProduct(Product prod);
}
