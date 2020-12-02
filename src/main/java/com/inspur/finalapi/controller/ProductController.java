package com.inspur.finalapi.controller;

import com.inspur.finalapi.bean.Product;
import com.inspur.finalapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
     @Autowired
     private ProductService productService;
     @Autowired
     private RedisTemplate redisTemplate;
    @PostMapping("/getProducts")
    public List<Product> getProductList(){
       return productService.getProductList();
    }
    @PostMapping("/addProduct")
    public String addProduct(Product product){
        return productService.addProduct(product);

    }
    @GetMapping("/findByName")
    public Product findByName(Product product){
        return productService.findByName(product.getName());

    }
    @PostMapping("/redis")
    public String redisops(){
        redisTemplate.opsForValue().set("stu","xihong");
        String stu =(String) redisTemplate.opsForValue().get("stu");
        System.out.println("stu===>"+stu);
        return "ok";
    }






}
