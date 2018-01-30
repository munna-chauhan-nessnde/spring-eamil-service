package com.vm.email.service;

import com.vm.email.domain.MailObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.List;
import java.util.Properties;

/**
 * @author munna.chauhan
 * https://docs.microsoft.com/en-us/azure/store-sendgrid-java-how-to-send-email#create-a-sendgrid-account
 */
@Component
public class EmailServiceImpl implements EmailService {

    private static final String SMTP_HOST_NAME = "smtp.sendgrid.net";
    private static final String SMTP_AUTH_USER = "your_sendgrid_username";
    private static final String SMTP_AUTH_PWD = "your_sendgrid_password";

    private class SMTPAuthenticator extends javax.mail.Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
            String username = SMTP_AUTH_USER;
            String password = SMTP_AUTH_PWD;
            return new PasswordAuthentication(username, password);
        }
    }
    @Override
    public void sendMail(MailObject mailObject) throws MessagingException {
// Local file name and path.
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.host", SMTP_HOST_NAME);
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.auth", "true");

        Authenticator auth = new SMTPAuthenticator();
        Session mailSession = Session.getDefaultInstance(properties, auth);
        MimeMessage message = new MimeMessage(mailSession);
        Multipart multipart = new MimeMultipart("alternative");
        BodyPart part1 = new MimeBodyPart();
        String attachmentName = "myfile.zip";
        String attachmentPath = "c:\\myfiles\\";
        MimeBodyPart attachmentPart = new MimeBodyPart();
// Specify the local file to attach.
        DataSource source = new FileDataSource(attachmentPath + attachmentName);
        attachmentPart.setDataHandler(new DataHandler(source));
// This example uses the local file name as the attachment name.
// They could be different if you prefer.
        attachmentPart.setFileName(attachmentName);
        multipart.addBodyPart(attachmentPart);
// add CC
        message.addRecipient(Message.RecipientType.CC, new
                InternetAddress("john@contoso.com"));
    }

 /*   @Autowired
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

    }*/
}
