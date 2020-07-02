package com.timebird.scheduleGetData.Service;

import com.timebird.scheduleGetData.Connector.MailConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class SendMailService {
    @Autowired
    MailConnector mailConnector;

    public void sendMail(String to, String subject, String content){
        mailConnector.connect();
        SimpleMailMessage message=new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        mailConnector.send(message);
    }
}
