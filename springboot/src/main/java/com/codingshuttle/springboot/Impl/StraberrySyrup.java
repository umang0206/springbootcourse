package com.codingshuttle.springboot.Impl;

import com.codingshuttle.springboot.Syrup;
import org.springframework.stereotype.Component;

@Component("strawberrySyrup")
public class StraberrySyrup implements Syrup {
    @Override
    public String getSyrupType() {
        return "Strawberry Syrup";
    }
}
