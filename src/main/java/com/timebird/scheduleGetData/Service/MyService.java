package com.timebird.scheduleGetData.Service;

import org.springframework.stereotype.Service;

public class MyService {
    public final int FLAG=1;

    public String getPath(){
        if(FLAG==1){
            return "/test1";
        }
        else{
            return "/test2";
        }
    }
}
