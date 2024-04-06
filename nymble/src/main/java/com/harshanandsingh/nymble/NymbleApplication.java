package com.harshanandsingh.nymble;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.harshanandsingh.nymble.model", "com.harshanandsingh.nymble.controller",
        "com.harshanandsingh.nymble.repository", "com.harshanandsingh.nymble.service"})
public class NymbleApplication {
    public static void main(String[] args) {
        SpringApplication.run(NymbleApplication.class, args);
    }
}
