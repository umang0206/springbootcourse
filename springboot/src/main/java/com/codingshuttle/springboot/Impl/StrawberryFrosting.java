package com.codingshuttle.springboot.Impl;

import com.codingshuttle.springboot.Frosting;
import org.springframework.stereotype.Component;

@Component("strawberryFrosting")
public class StrawberryFrosting implements Frosting {
    @Override
    public String getFrostingType() {
        return "Strawberry Frosting";
    }
}
