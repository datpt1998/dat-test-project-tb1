package com.timebird.scheduleGetData;

import com.timebird.scheduleGetData.Connector.MailConnector;
import com.timebird.scheduleGetData.Connector.MySQLConnector;
import com.timebird.scheduleGetData.DAO.UserDAO;
import com.timebird.scheduleGetData.DAO.testLDAP;
import com.timebird.scheduleGetData.Service.SendMailService;
import com.timebird.scheduleGetData.helper.TestMoreParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
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
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

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

//		testLDAP LDAPDAO= (testLDAP) applicationContext.getBean("testLDAP");
//		LDAPDAO.test();

//		Calendar calendar=Calendar.getInstance();
//		calendar.set(Calendar.DATE, 0);
//		System.out.println(calendar.getTime());

//		TestMoreParam testMoreParam=new TestMoreParam();
//		testMoreParam.test(4,"haha", "hoho", "hihi");

//		System.out.println(new Date().getTime());

//		SendMailService mailService=(SendMailService)applicationContext.getBean("sendMailService");
//		String[] to={"datpt@timebird.org","cuongtt@timebird.org",
//				"thamnt@timebird.org","nhatcl@timebird.org","quangnh@timebird.org","linhht@timebird.org"};
//		String subject="Mail from spring boot project";
//		for(String s:to){
//			mailService.sendMail(s,subject,"Hello to "+s+" from spring boot");
//			Thread.sleep(30000);
//		}


//		for(String s:ZoneId.getAvailableZoneIds()){
//			System.out.println(ZonedDateTime.ofInstant(new Date().toInstant(),ZoneId.of(s)));
//		}

//		System.out.println(ZonedDateTime.ofInstant(new Date().toInstant(),ZoneId.of("Asia/Ho_Chi_Minh")).toInstant().toEpochMilli());
//		System.out.println(ZonedDateTime.ofInstant(new Date().toInstant(),ZoneId.of("Antarctica/Casey")).toInstant().toEpochMilli());

//		for(String s:TimeZone.getAvailableIDs()){
		//TimeZone.setDefault(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
//		System.out.println(TimeZone.getDefault());
//		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		//simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
//		System.out.println(simpleDateFormat.parse("07/08/2020 11:53:00"));
//		System.out.println(simpleDateFormat.format(new Date()));
//		}

		System.out.println(Calendar.getInstance().getTime());

//		for(Locale locale:Locale.getAvailableLocales()){
//			System.out.println(Calendar.getInstance(locale).getTime());
//		}
	}

	@Bean
	public TaskScheduler taskScheduler() {
		final ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
		scheduler.setPoolSize(3);
		return scheduler;
	}

}
