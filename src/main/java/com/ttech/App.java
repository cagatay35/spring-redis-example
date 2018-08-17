package com.ttech;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ttech.redis")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
