package com.vm.email.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
public class MailObject {

    @Email
    @NotNull
    @Size(min = 1, message = "Please, set an email address to send the message to it")
    private List<String> mailTOs = new ArrayList<>();
    private List<String> mailCCs = new ArrayList<>();
    private String from;
    private String fromName;
    private String subject;
    private String mailContent;
    private String pathToAttachment;
}
