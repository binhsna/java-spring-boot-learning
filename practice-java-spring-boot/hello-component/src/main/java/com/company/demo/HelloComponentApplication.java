package com.company.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HelloComponentApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(HelloComponentApplication.class, args);

        Outfit outfit = context.getBean(Outfit.class);

        System.out.println("Instance: " + outfit);
        outfit.wear();
    }
}
