package com.Email;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @GetMapping("/send/mail")
    public String getMail() throws InterruptedException {

        logger.debug("I have hit the point man !");

        return "Hello i hve sent the mail to the client";
    }
}
