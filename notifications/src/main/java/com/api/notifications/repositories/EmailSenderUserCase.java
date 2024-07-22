package com.api.notifications.repositories;

public interface EmailSenderUserCase {

    void sendEmail(String to , String subject , String body);


}
