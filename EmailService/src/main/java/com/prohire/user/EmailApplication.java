package com.prohire.user;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmailApplication {
    public static void main(String[] args) throws Exception {
        new AnnotationConfigApplicationContext("com.prohire");
    }
}
