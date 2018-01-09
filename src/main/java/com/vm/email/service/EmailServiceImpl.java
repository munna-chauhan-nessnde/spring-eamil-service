package com.vm.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author munna.chauhan
 */
@Component
public class EmailServiceImpl implements EmailService {

    @Autowired
    public JavaMailSender emailSender;

    @Override
    public void sendSimpleMessage(String from, String fromName, List<String> mailTOs, String subject, String mailContent) {

    }

    @Override
    public void sendSimpleMessageUsingTemplate(String from, String fromName, List<String> mailTOs, List<String> mailCCs, String subject, String mailContent, SimpleMailMessage template, String... templateArgs) {

    }

    @Override
    public void sendMessageWithAttachment(String from, String fromName, List<String> mailTOs, List<String> mailCCs, String subject, String mailContent, String pathToAttachment) {

    }

    @Override
    public void sendMessageUsingTemplateWithAttachment(String from, String fromName, List<String> mailTOs, List<String> mailCCs, String subject, String mailContent, String pathToAttachment, SimpleMailMessage template, String... templateArgs) {

    }
}
