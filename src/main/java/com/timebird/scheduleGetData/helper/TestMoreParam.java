package com.timebird.scheduleGetData.helper;

public class TestMoreParam {
    public void test(Integer c, String... a){
        for(String s:a){
            System.out.println(s);
        }
        System.out.println(c);
    }
}
