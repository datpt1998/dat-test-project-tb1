package com.timebird.scheduleGetData.DAO;

import com.mongodb.MongoClient;
import com.timebird.scheduleGetData.Connector.MongoConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class testMongo {
    @Autowired
    MongoConnector mongoConnector;

    public void test(){
        MongoClient client=mongoConnector.getConnection();
        System.out.println(client.getDatabase("timesheet").getCollection("user").countDocuments());
    }
}
