package com.inspur.finalapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FinalapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalapiApplication.class, args);
    }

}
