package com.timebird.scheduleGetData.Connector;

import com.timebird.scheduleGetData.my_interface.TestLambda;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class TestLambdaConfig {
    List<String> strings = new ArrayList<>();

    public List<String> getStrings() {
        return strings;
    }

    public TestLambda myTestLambda()
    {
        return name -> {
            System.out.println("Hello "+name);
        };
    }

    public void for4Times (TestLambda testLambda)
    {
        for(int i=0; i<4; i++){
            testLambda.test("lalal");
        }
    }

    public void forEach (TestLambda testLambda){
        for(String s:strings){
            testLambda.test(s);
        }
    }
}
