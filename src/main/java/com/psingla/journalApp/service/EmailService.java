package com.psingla.journalApp.service;

import com.psingla.journalApp.entity.Email;
import com.psingla.journalApp.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Service
@RequestMapping("/email")
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(Email email){
        try{
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo(email.getTo());
            mail.setSubject(email.getSubject());
            mail.setText(email.getBody());
            javaMailSender.send(mail);
            log.info("Email sent successfully to {}", email.getTo());
        }
        catch(Exception e){
            log.error("Error while sending email", e);
        }
    }
}
