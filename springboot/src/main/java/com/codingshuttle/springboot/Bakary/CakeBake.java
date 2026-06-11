package com.codingshuttle.springboot.Bakary;

import com.codingshuttle.springboot.Frosting;
import com.codingshuttle.springboot.Syrup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CakeBake {


    final Frosting frosting;
    final Syrup syrup;
    CakeBake(@Qualifier("strawberryFrosting") Frosting frosting, @Qualifier("chocolateSyrup") Syrup syrup){
        this.frosting = frosting;
        this.syrup = syrup;
    }
    public void backCake(){
        System.out.println("Cake bake with " + frosting.getFrostingType() + " and "+ syrup.getSyrupType());
    }
}
