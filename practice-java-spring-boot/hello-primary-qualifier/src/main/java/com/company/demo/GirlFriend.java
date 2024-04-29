package com.company.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GirlFriend {
    public Outfit outfit;

    public GirlFriend() {
    }

    @Autowired
    public GirlFriend(@Qualifier("bikini") Outfit outfit) {
        this.outfit = outfit;
    }

    public void setOutfit(Outfit outfit) {
        this.outfit = outfit;
    }

    public Outfit getOutfit() {
        return this.outfit;
    }
}
