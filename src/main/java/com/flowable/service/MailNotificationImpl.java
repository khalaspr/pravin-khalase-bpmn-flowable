package com.flowable.service;

import org.springframework.stereotype.Service;

@Service
public class MailNotificationImpl implements MailNotification {
    @Override
    public void sendSuccessAlert() {
        System.out.println("Sending email notification");
    }

    @Override
    public void sendCertificate() {
        System.out.println("Sending Certificate");
    }
}
