package com.codingshuttle.springboot.Impl;

import com.codingshuttle.springboot.Frosting;
import org.springframework.stereotype.Component;

@Component("chocolateFrosting")
public class ChocolateFrosting implements Frosting {
    @Override
    public String getFrostingType() {
        return "Chocolate Frosting";
    }
}
