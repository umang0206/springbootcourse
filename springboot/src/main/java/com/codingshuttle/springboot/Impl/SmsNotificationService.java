package com.codingshuttle.springboot.Impl;

import com.codingshuttle.springboot.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("sms")
public class SmsNotificationService implements NotificationService {

    @Override
    public void send(String message) {
        System.out.println("sms sending....."+ message);
    }
}
