package com.vm.email.config;

import com.vm.email.domain.MailObject;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@CommonsLog
public class EmailSender {

    /**
     * Before send mail first prepare @MailObject
     * @param mailObject
     */
    public void prepareAndSend(MailObject mailObject) {
     log.info("Mail Send Successfully!");
  }
}
