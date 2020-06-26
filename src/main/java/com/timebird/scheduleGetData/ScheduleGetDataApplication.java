package com.timebird.scheduleGetData;

import com.timebird.scheduleGetData.Connector.MySQLConnector;
import com.timebird.scheduleGetData.DAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;

import java.sql.SQLException;

@SpringBootApplication(exclude= MongoAutoConfiguration.class)
public class ScheduleGetDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScheduleGetDataApplication.class, args);
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(ScheduleGetDataApplication.class);
		UserDAO userDAO= (UserDAO) context.getBean("userDAO");
		System.out.println(userDAO.getAllUser());
	}

}
