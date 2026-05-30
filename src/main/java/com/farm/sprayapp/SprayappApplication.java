package com.farm.sprayapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.farm")
@EnableJpaRepositories(basePackages = "com.farm.repository")
@EntityScan(basePackages = "com.farm.entity")
public class SprayappApplication {
    public static void main(String[] args) {
        SpringApplication.run(SprayappApplication.class, args);
        
    }
}

