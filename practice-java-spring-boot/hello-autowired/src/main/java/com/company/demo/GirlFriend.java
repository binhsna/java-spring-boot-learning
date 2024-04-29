package com.company.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GirlFriend {
    @Autowired
    public Outfit outfit;

    public GirlFriend() {
        // Cách cùi bắp :))
        //this.outfit = new Dress();
    }

    public GirlFriend(Outfit outfit) {
        this.outfit = outfit;
    }

    public void setOutfit(Outfit outfit) {
        this.outfit = outfit;
    }

    public Outfit getOutfit() {
        return this.outfit;
    }
}
