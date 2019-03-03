package com.cedo.cat2server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Cat2ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Cat2ServerApplication.class, args);
    }

}
