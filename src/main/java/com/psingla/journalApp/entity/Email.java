package com.psingla.journalApp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Email {
    String to;
    String subject;
    String body;
}
