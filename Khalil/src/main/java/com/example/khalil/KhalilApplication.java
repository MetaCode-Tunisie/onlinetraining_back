package com.example.khalil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class KhalilApplication {

    public static void main(String[] args) {
        SpringApplication.run(KhalilApplication.class, args);
    }

}
