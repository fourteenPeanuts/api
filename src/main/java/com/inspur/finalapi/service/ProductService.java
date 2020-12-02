package com.inspur.finalapi.service;

import com.inspur.finalapi.bean.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {

    public List<Product> getProductList();


    String addProduct(Product product);

    Product findByName(String name);
}
