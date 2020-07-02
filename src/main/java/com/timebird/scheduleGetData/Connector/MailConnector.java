package com.timebird.scheduleGetData.Connector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
@PropertySource("classpath:application.properties")
public class MailConnector extends JavaMailSenderImpl {
    @Autowired
    Environment environment;

    public MailConnector(){

    }

    public void connect(){
        setHost(environment.getProperty("mail.host"));
        try {
            setPort(Integer.parseInt(environment.getProperty("mail.port")));
        }
        catch (NumberFormatException e){
            System.out.printf("Your port is not integer");
        }
        setUsername(environment.getProperty("mail.username"));
        String password="";
        String[] encodeGroup=environment.getProperty("mail.password").split("-");
        for(String s:encodeGroup){
            password=password+(char)Integer.parseInt(s);
        }
        setPassword(password);
        Properties props = getJavaMailProperties();
        props.put("mail.transport.protocol", environment.getProperty("mail.protocol"));
        props.put("mail.smtp.auth", environment.getProperty("mail.auth"));
        props.put("mail.smtp.starttls.enable", environment.getProperty("mail.starttls.enable"));
        props.put("mail.debug", environment.getProperty("mail.debug"));
    }

}
