package com.example.HRM.common;

import lombok.Data;

import java.util.List;

@Data
public class Email {

    private List<String> sendToMail;

    private String subject;

    private String text;
}
