package com.bootcamp.demo.notification.services;

import com.bootcamp.demo.notification.contracts.NotificationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class EmailNotificationService implements NotificationService {

    @Value("${app.notifications.emailsender}")
    private String sender;

    @Override
    public void notifyServ(String msg){
        System.out.println("[" + getClass().getSimpleName() + "] enviar email: " + msg + " - por: " + this.sender);
    }

}
