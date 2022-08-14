package org.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.core.*")
public class RestServerApplication {

    public static void main(String[] args){
        SpringApplication.run(RestServerApplication.class, args);
    }
}
