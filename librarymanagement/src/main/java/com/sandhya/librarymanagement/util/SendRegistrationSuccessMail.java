package com.sandhya.librarymanagement.util;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.context.Context;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;


public class SendRegistrationSuccessMail {

    @Autowired
     private JavaMailSender javaMailSender;

    @Autowired
    private final SpringTemplateEngine springTemplateEngine;

    public SendRegistrationSuccessMail(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    public String sendAnEmail(String email, String Message) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            Map<String, Object> mydata = new HashMap<String, Object>();
            mydata.put("username", email);

            helper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED, StandardCharsets.UTF_8.name());

            Context context = new Context();
            context.setVariables(mydata);

            helper.setFrom("sandhya0609a@gmail.com");
            helper.setTo(email);
            helper.setSubject("Registration Successful");


            String template = springTemplateEngine.process("registration", context);
            helper.setText(template, true);
            javaMailSender.send(mimeMessage);

            return "sent message";

        } catch (MessagingException e) {
            e.printStackTrace();
            throw  e;
        }
    }

}


