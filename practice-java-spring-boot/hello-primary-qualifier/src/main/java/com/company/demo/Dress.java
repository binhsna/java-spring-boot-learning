package com.company.demo;

import org.springframework.stereotype.Component;

@Component("dress")
public class Dress implements Outfit {
    @Override
    public void wear() {
        System.out.println("Đang mặc váy");
    }
}
