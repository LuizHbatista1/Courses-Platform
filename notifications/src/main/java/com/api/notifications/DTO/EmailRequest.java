package com.api.notifications.DTO;

public record EmailRequest(String to , String subject , String body) {
}
