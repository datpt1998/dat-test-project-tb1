package com.timebird.scheduleGetData.Connector;

import com.mongodb.MongoClientURI;
import org.springframework.stereotype.Component;

@Component
public class MongoConnector {
    public MongoClientURI getConnection(){
        return new MongoClientURI("mongodb://localhost:27017/testSakila");
    }
}
