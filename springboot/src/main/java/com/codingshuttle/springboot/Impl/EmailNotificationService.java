package com.codingshuttle.springboot.Impl;

import com.codingshuttle.springboot.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary //Primary annotation tells if two beans are there then please prioritize this class bean
@Component
//@Qualifier("email") //using the Qualifier spring knows which bean need to be injected
public class EmailNotificationService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Email sending..."+ message);
    }
}
