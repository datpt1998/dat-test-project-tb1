package com.timebird.scheduleGetData.Service;

import com.timebird.scheduleGetData.Connector.MailConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class SendMailService {
    @Autowired
    MailConnector mailConnector;
    @Autowired
    private ThymeLeafService thymeLeafService;

    public void sendMail(String to, String subject, String content){
        mailConnector.connect();
        SimpleMailMessage message=new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        mailConnector.send(message);
    }

    public void sendMimeMail(String to, String subject){
        mailConnector.connect();
        Thread thread=new Thread(){
            @Override
            public void run() {
                MimeMessage message=mailConnector.createMimeMessage();
                try {
                    MimeMessageHelper helper=new MimeMessageHelper(message);
                    helper.setTo(to);
                    helper.setSubject(subject);
                    message.setContent(thymeLeafService.getContent(to),"text/html;charset=\"utf-8\"");
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                mailConnector.send(message);
            }
        };
        thread.start();
    }
}
