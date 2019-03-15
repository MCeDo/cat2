package com.cedo.cat2shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.cedo")
public class Cat2ShopWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(Cat2ShopWebApplication.class, args);
    }

}
