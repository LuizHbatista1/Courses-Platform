package com.api.notifications.service;


import com.api.notifications.repositories.EmailSenderGateway;
import com.api.notifications.repositories.EmailSenderUserCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService implements EmailSenderUserCase {

    @Autowired
    private final EmailSenderGateway emailSenderGateway;

    @Autowired
    public EmailSenderService(EmailSenderGateway emailSenderGateway){

        this.emailSenderGateway = emailSenderGateway;

    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        this.emailSenderGateway.sendEmail(to , subject , body);
    }

}
