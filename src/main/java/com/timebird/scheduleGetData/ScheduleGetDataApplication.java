package com.timebird.scheduleGetData;

import com.timebird.scheduleGetData.Connector.MailConnector;
import com.timebird.scheduleGetData.Connector.MySQLConnector;
import com.timebird.scheduleGetData.DAO.UserDAO;
import com.timebird.scheduleGetData.DAO.testLDAP;
import com.timebird.scheduleGetData.Service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.ldap.InitialLdapContext;
import java.sql.SQLException;
import java.util.Scanner;

@SpringBootApplication(exclude= MongoAutoConfiguration.class)
@EnableScheduling
public class ScheduleGetDataApplication implements CommandLineRunner {

	@Autowired
	private ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(ScheduleGetDataApplication.class, args);
//		AnnotationConfigApplicationContext context=
//				new AnnotationConfigApplicationContext(ScheduleGetDataApplication.class);
//        DirContext dirContext=

//        Scanner scan=new Scanner(System.in);
//        String password=scan.nextLine();
//        for(char c:password.toCharArray()){
//            System.out.print((int)c+"-");
//        }
	}

	@Override
	public void run(String... args) throws Exception {
		testLDAP LDAPDAO= (testLDAP) applicationContext.getBean("testLDAP");
		LDAPDAO.test();
//		SendMailService mailService=(SendMailService)applicationContext.getBean("sendMailService");
//		String[] to={"datpt@timebird.org","cuongtt@timebird.org",
//				"thamnt@timebird.org","nhatcl@timebird.org","quangnh@timebird.org","linhht@timebird.org"};
//		String subject="Mail from spring boot project";
//		for(String s:to){
//			mailService.sendMail(s,subject,"Hello to "+s+" from spring boot");
//			Thread.sleep(30000);
//		}
	}

	@Bean
	public TaskScheduler taskScheduler() {
		final ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
		scheduler.setPoolSize(3);
		return scheduler;
	}

}
