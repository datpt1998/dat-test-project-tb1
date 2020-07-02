package com.timebird.scheduleGetData.Connector;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class MongoConnector {

    @Autowired
    private Environment environment;
    public MongoClient getConnection(){
        String account=(environment.getProperty("mongo.username").trim().equals("")||
                environment.getProperty("mongo.password").trim().equals(""))?"":
                String.format("%s:%s@",environment.getProperty("mongo.username"),
                        environment.getProperty("mongo.password"));
        String port=environment.getProperty("mongo.port").trim().equals("")?"":
                String.format(":%s",environment.getProperty("mongo.port"));
        String connectionString=String.format("mongodb://%s%s%s/%s",account,
                environment.getProperty("mongo.host"),port,environment.getProperty("mongo.defaultdatabase"));
        MongoClientURI uri=new MongoClientURI(connectionString);
        return new MongoClient(uri);
    }
}
