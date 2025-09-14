package com.psingla.journalApp.controller;

import com.psingla.journalApp.entity.Email;
import com.psingla.journalApp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-email")
    public ResponseEntity<?> sendEmail(@RequestBody Email email){
        try{
            emailService.sendEmail(email);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            System.out.println("Error while sending email" + e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
