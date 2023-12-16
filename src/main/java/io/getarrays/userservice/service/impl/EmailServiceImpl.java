/**
 * @author: Bek
 * Date: 12/16/2023
 * Time: 3:43 PM
 * Project Name: userservice
 */

package io.getarrays.userservice.service.impl;

import io.getarrays.userservice.service.EmailService;
import io.getarrays.userservice.utils.EmailUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import static io.getarrays.userservice.utils.EmailUtils.*;


@RequiredArgsConstructor
@Service
public class EmailServiceImpl  implements EmailService {

    public static final String NEW_USER_ACCOUNT_VERIFICATION = "New User Account Verification";
    @Value("${spring.mail.verify.host}")
    private String host;
    @Value("${spring.mail.username}")
    private String fromEmail;
    private final JavaMailSender emailSender;



    private final JavaMailSender javaMailSender;

    @Override
    @Async
    public void sendSimpleMailMessage(String name, String to, String token) {
        try {

            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject(NEW_USER_ACCOUNT_VERIFICATION);
            message.setTo(to);
            message.setFrom(fromEmail);
            message.setText(getEmailMessage(name,host,token));
            emailSender.send(message);

        }catch (Exception exception){
            System.out.println(exception.getMessage());
            throw new RuntimeException(exception.getMessage());
        }
    }

    @Override
    @Async
    public void sendMimeMessageWithAttachements(String name, String to, String token) {

    }

    @Override
    @Async
    public void sendMimeMessageWithEmbeddedImages(String name, String to, String token) {

    }

    @Override
    @Async
    public void sendMimeMessageWithEmbedFiles(String name, String to, String token) {

    }

    @Override
    @Async
    public void sendHtmlEmail(String name, String to, String token) {

    }

    @Override
    @Async
    public void sendHtmlEmailWithEmbeddedFiles(String name, String to, String token) {

    }
}
