package com.timebird.scheduleGetData.Service;

import org.springframework.stereotype.Service;

@Service
public class TimeConvertService {
    public static String convertHour(double hour){
        int totalMinute = (int) Math.floor(hour*60);
        int numOfHour = totalMinute/60;
        int numOfMinute = totalMinute - (numOfHour*60);
        return numOfHour+":"+numOfMinute;
    }

    public static void main(String[] args) {
        System.out.println(convertHour(1.95));
        System.out.println(convertHour(1.45));
        System.out.println(convertHour(1.5));

//        // get two double numbers
//        double x = 60984.1;
//        double y = -497.99;
//
//        // call floor and print the result
//        System.out.println("Math.floor(" + x + ")=" + Math.floor(x));
//        System.out.println("Math.floor(" + y + ")=" + Math.floor(y));
//        System.out.println("Math.floor(0)=" + Math.floor(0));
//
//        // get two double numbers
//        double a = 125.9;
//        double b = 0.4873;
//
//        // call ceal for these these numbers
//        System.out.println("Math.ceil(" + a + ")=" + Math.ceil(a));
//        System.out.println("Math.ceil(" + b + ")=" + Math.ceil(b));
//        System.out.println("Math.ceil(-0.65)=" + Math.ceil(-0.65));
    }
}
