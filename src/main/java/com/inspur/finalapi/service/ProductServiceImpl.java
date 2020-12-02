package com.inspur.finalapi.service;

import com.inspur.finalapi.bean.Product;
import com.inspur.finalapi.reposity.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> getProductList() {
        return productRepository.findAll();
    }
    @Override
    public String addProduct(Product product) {
        System.out.println(product.getName());
        Product productReturn= productRepository.save(product);
        if(productReturn!=null){
            System.out.println("插入成功");
           // this.deleteProduct();
            return "OK";
        }else {
            System.out.println("插入失败");
            return "faile";
        }
    }
    @Override
    @Cacheable(value = "product")
    public Product findByName(String name) {
        System.out.println("如果没有就不走缓存了");
        return productRepository.findByName(name);
    }
}
