package com.codingshuttle.springboot.Impl;

import com.codingshuttle.springboot.Syrup;
import org.springframework.stereotype.Component;

@Component("chocolateSyrup")
public class ChocolateSyrup implements Syrup {
    @Override
    public String getSyrupType() {
        return "Chocolate syrup";
    }
}
