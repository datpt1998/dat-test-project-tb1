package com.timebird.scheduleGetData.schedulejob;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TransferDataJob {
    @Scheduled(cron = "1 * * * * *")
    public void mySche(){
        System.out.println("hello, now is"+new Date());
    }
}
