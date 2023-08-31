package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Main Class
@SpringBootApplication
public class CabManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(CabManagementApplication.class, args);
        System.out.println("Welcome to Cab Management Application.");
    }
}