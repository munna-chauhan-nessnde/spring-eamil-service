package com.vm.email.service;

import org.springframework.mail.SimpleMailMessage;

import java.util.List;

/**
 * @author munna.chauhan
 */
public interface EmailService {
    /**
     *
     * @param from
     * @param fromName
     * @param mailTOs
     * @param subject
     * @param mailContent
     */
    void sendSimpleMessage(String from,
                           String fromName,
                           List<String> mailTOs,
                           String subject,
                           String mailContent);
    /**
     *
     * @param from
     * @param fromName
     * @param mailTOs
     * @param mailCCs
     * @param subject
     * @param mailContent
     * @param template
     * @param templateArgs
     */
    void sendSimpleMessageUsingTemplate(String from,
                                        String fromName,
                                        List<String> mailTOs,
                                        List<String> mailCCs,
                                        String subject,
                                        String mailContent,
                                        SimpleMailMessage template,
                                        String ...templateArgs);
    /**
     *
     * @param from
     * @param fromName
     * @param mailTOs
     * @param mailCCs
     * @param subject
     * @param mailContent
     * @param pathToAttachment
     */
    void sendMessageWithAttachment(String from,
                                   String fromName,
                                   List<String> mailTOs,
                                   List<String> mailCCs,
                                   String subject,
                                   String mailContent,
                                   String pathToAttachment);
    /**
     *
     * @param from
     * @param fromName
     * @param mailTOs
     * @param mailCCs
     * @param subject
     * @param mailContent
     * @param pathToAttachment
     * @param template
     * @param templateArgs
     */
    void sendMessageUsingTemplateWithAttachment(String from,
                                   String fromName,
                                   List<String> mailTOs,
                                   List<String> mailCCs,
                                   String subject,
                                   String mailContent,
                                   String pathToAttachment,
                                   SimpleMailMessage template,
                                   String ...templateArgs);
}
