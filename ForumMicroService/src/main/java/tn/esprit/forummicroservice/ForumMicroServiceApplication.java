package tn.esprit.forummicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ForumMicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForumMicroServiceApplication.class, args);
    }

}
