package com.api.notifications.repositories;

public interface EmailSenderGateway {

    void sendEmail(String to , String subject , String body);

}
