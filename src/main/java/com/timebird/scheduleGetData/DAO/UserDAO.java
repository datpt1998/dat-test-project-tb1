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
        String query="select userid, Username, DOB, Name , Address , Phone , Email , Gender " +
                "from user where Name is NOT null and Name<>'' and userid <> 9503402";
        try {
            connection=connector.getMySQLConnection();
            statement=connection.prepareStatement(query);
            resultSet=statement.executeQuery();
            while(resultSet.next()){
                String id=resultSet.getString("userid");
                String name=resultSet.getString("Name");
                String username=resultSet.getString("Username");
                Date birthday=resultSet.getDate("DOB");
                String address=resultSet.getString("Address");
                String mail=resultSet.getString("Email");
                String role="Normal";
                String gender=resultSet.getString("Gender");
                users.add(new User(id, name, username, birthday, address, mail, role, gender));
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
