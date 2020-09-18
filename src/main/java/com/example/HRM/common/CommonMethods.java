package com.example.HRM.common;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class CommonMethods {

    public boolean isEmailGmail(String email) {
        String query = "[a-z][a-z0-9_\\.]{2,32}@gmail.com";
        return Pattern.matches(query, email);
    }
}
