package com.yasmin.email_service.application;

import com.yasmin.email_service.adapters.EmailSenderGateway;
import com.yasmin.email_service.core.EmailSenderUserCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService implements EmailSenderUserCase {

    private final EmailSenderGateway emailSenderGateway;

    @Autowired
    public EmailSenderService(EmailSenderGateway senderGateway) {
        this.emailSenderGateway = senderGateway;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        emailSenderGateway.sendEmail(to, subject, body);
    }
}
