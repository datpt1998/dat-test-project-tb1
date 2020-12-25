package com.timebird.scheduleGetData.helper;

import com.timebird.scheduleGetData.annotation.MyAnot;

public class TestMoreParam {
    private double a;

    public double getA() {
        return a;
    }

    public static final String HELLO="123";
    public void test(Integer c, String... a){
        for(String s:a){
            System.out.println(s);
        }
        System.out.println(c);
    }

    public void testTryCatch(){
        try{
            System.out.println("go try");
            throw new Exception();
        } catch(Exception e){
            System.out.println("go catch");
            return;
        }
        finally {
            System.out.println("go final");
        }
        //System.out.println("go normal");
    }

    @MyAnot(value = "#value")
    public void testAnot(String value){

    }

    public void testString(String s){
        if(s.equals("conbo"))
        {
            s="conlon";
        }
        System.out.println(s);
    }
}
