package com.timebird.scheduleGetData.Connector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


import java.sql.*;

@Component
@PropertySource("classpath:application.properties")
public class MySQLConnector {

    @Autowired
    private Environment environment;

    public Connection getMySQLConnection() {
        Connection conn=null;
        try {
            String templateConnectionString="jdbc:mysql://%s:%s/%s";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(String.format(templateConnectionString,
                    environment.getProperty("mysql.host"),
                    environment.getProperty("mysql.port"),
                    environment.getProperty("mysql.database")),
                    environment.getProperty("mysql.username"),
                    environment.getProperty("mysql.password"));
            System.out.println("connect successfully!");
        }catch(Exception e) {
            System.out.println("connect failure!");
            e.printStackTrace();
        }
        return conn;
    }

    public void closeConnection(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if(resultSet!=null&&!resultSet.isClosed()){
                resultSet.close();
            }
            if(statement!=null&&!statement.isClosed()){
                resultSet.close();
            }
            if(connection!=null&&!connection.isClosed()){
                connection.close();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
