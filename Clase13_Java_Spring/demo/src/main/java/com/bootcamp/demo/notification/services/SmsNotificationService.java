package com.bootcamp.demo.notification.services;

import com.bootcamp.demo.notification.contracts.NotificationService;
import org.springframework.stereotype.Service;

@Service
public class SmsNotificationService implements NotificationService {

    @Override
    public void notifyServ(String msg){
        System.out.println("enviar SMS: " + msg);
    }

}
