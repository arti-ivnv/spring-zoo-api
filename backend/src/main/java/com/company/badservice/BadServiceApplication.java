package com.company.badservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @Import(InitService.class)
public class BadServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BadServiceApplication.class, args);
    }

}
