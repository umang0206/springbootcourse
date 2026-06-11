package com.codingshuttle.springboot;

import com.codingshuttle.springboot.Impl.SmsNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class SpringbootApplication implements CommandLineRunner {

//	@Autowired
//	NotificationService notificationService; //Field dependency injection

//	NotificationService notificationService;
//	public SpringbootApplication(@Qualifier("sms") NotificationService notificationService){   //This is called constructor dependency injection because my SpringbootApplication class is dependent on Notification class and bean of that class will be provided by Spring IOC
//		this.notificationService=notificationService;
//	}

	@Autowired
	Map<String, NotificationService> notificationServiceHashMap = new HashMap<>();  //if we want to get all the instance of the use beans of same type then we should use in the form of MAP dependency injection

	@Autowired
	SmsNotificationService smsNotificationService; //Field dependency injection
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		notificationService.send("Hello");
//		smsNotificationService.send("Hello sms");

		for(var notificationservice:notificationServiceHashMap.entrySet()) {
			System.out.println(notificationservice.getKey());
			notificationservice.getValue().send("hello");
		}

	}
}
