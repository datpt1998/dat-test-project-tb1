package com.timebird.scheduleGetData.DAO;

import com.mongodb.MongoClient;
import com.timebird.scheduleGetData.Connector.MongoConnector;
import com.timebird.scheduleGetData.Connector.MySQLConnector;
import com.timebird.scheduleGetData.entity.User;
import org.bson.BsonDocument;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class UserDAO {
    @Autowired
    MySQLConnector connector;
    @Autowired
    MongoConnector mongoConnector;

    public List<User> getAllUser(){
        List<User> users=new ArrayList<>();
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        String query="select customer_id, last_name, email " +
                "from customer";
        try {
            connection=connector.getMySQLConnection();
            statement=connection.prepareStatement(query);
            resultSet=statement.executeQuery();
            while(resultSet.next()){
                String id=resultSet.getString("customer_id");
                String name=resultSet.getString("last_name");
                String mail=resultSet.getString("email");
                users.add(new User(id, name, "username", null, "address", mail, "role", "gender"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            connector.closeConnection(connection, statement, resultSet);
        }
        return users;
    }

    public User getUserByMail(String mail){
        MongoClient mongoClient=mongoConnector.getConnection();
        Document docUser=mongoClient
                .getDatabase("timesheet")
                .getCollection("user")
                .find(new Document().append("mail", mail)).first();
        User user=new User();
        user.setMail(docUser.getString("mail"));
        user.setRole(docUser.getString("role"));
        return user;
    }
}
