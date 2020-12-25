package com.timebird.scheduleGetData;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.timebird.scheduleGetData.Connector.MailConnector;
import com.timebird.scheduleGetData.Connector.MySQLConnector;
import com.timebird.scheduleGetData.Connector.TestLambdaConfig;
import com.timebird.scheduleGetData.DAO.UserDAO;
import com.timebird.scheduleGetData.DAO.testLDAP;
import com.timebird.scheduleGetData.Modal.ServiceResult;
import com.timebird.scheduleGetData.Service.SendMailService;
import com.timebird.scheduleGetData.annotation.MyAnot;
import com.timebird.scheduleGetData.helper.Constant;
import com.timebird.scheduleGetData.helper.TestMoreParam;
import com.timebird.scheduleGetData.my_interface.TestLambda;
import io.jsonwebtoken.SignatureAlgorithm;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.ClassicConfiguration;
import org.flywaydb.core.api.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayProperties;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.ldap.InitialLdapContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

import static com.timebird.scheduleGetData.helper.Constant.HELLO;
import static com.timebird.scheduleGetData.helper.Constant.print;

@SpringBootApplication(exclude= MongoAutoConfiguration.class)
@EnableScheduling
public class ScheduleGetDataApplication implements CommandLineRunner {

	@Autowired
	private ApplicationContext applicationContext;
	@Autowired
	private SendMailService sendMailService;
	@Value("${me.test}")
	String test;
	@Autowired
	TestLambdaConfig testLambdaConfig;

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

//		System.out.println(Calendar.getInstance().getTime());

//		for(Locale locale:Locale.getAvailableLocales()){
//			System.out.println(Calendar.getInstance(locale).getTime());
//		}

//		String[] mails={"datpt@timebird.org"};
//		for(String s:mails){
//			sendMailService.sendMimeMail(s,"hello");
//		}

//		List<String> strings=new ArrayList<>();
//		strings.add("haha");
//		System.out.println(strings.get(1));

//		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd MMMM yyyy");
//		System.out.println(simpleDateFormat.format(new Date()).toUpperCase());
//		for(String s:simpleDateFormat.format(new Date()).split("/")){
//			System.out.println(s);
//		}

//		System.out.println(new Date(1596646800));
//		Calendar calendar=Calendar.getInstance();
//		System.out.println(calendar.getTime().getTime());
//		calendar.set(Calendar.HOUR_OF_DAY,1);
//		System.out.println(calendar.getTime().getTime());

		TestMoreParam testMoreParam=new TestMoreParam();
//		System.out.println(testMoreParam.getA());
//
//		testMoreParam.testTryCatch();
//
//		Method method=TestMoreParam.class.getMethod("testAnot", String.class);
//		method.invoke(testMoreParam, "lala");
//		MyAnot anot=method.getAnnotation(MyAnot.class);
//		System.out.println(anot.value());
//		System.out.println(test);
//        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("persistance");
//        EntityManager entityManager=entityManagerFactory.createEntityManager();
//        entityManager.

//		testLambdaConfig.myTestLambda().test("Con bo");
//		testLambdaConfig.for4Times(name -> System.out.println("yeah yeah "+name));
//		testLambdaConfig.getStrings().add("con bo");
//		testLambdaConfig.getStrings().add("con ga");
//		testLambdaConfig.getStrings().add("con lon");
//		testLambdaConfig.forEach(name -> {
//			System.out.println("Yolo "+name+" "+new Date());
//		});
//		String s1="TRẢ LÃI";
//		String s2="KINH DOANH";
//		String t1="i";
//		String t2= "a";
//		String t3 = "in";
//		System.out.println(s1.toLowerCase().contains(t1.toLowerCase())+" "+s2.toLowerCase().contains(t1.toLowerCase()));
//		System.out.println(s1.toLowerCase().contains(t2.toLowerCase())+" "+s2.toLowerCase().contains(t2.toLowerCase()));
//		System.out.println(s1.toLowerCase().contains(t3.toLowerCase())+" "+s2.toLowerCase().contains(t3.toLowerCase()));
//		testMoreParam.testString("conbo");
//		testMoreParam.testString("conga");
//		testMoreParam.testString("conlon");
//		testMoreParam.testString("congido");
//		testMoreParam.testString("conbo");
//		System.out.println(new Date(0));
//        System.out.println(SignatureAlgorithm.HS256.getValue());
//        System.out.println("làng".equals("làng"));
//        System.out.println("á".equals("a"));

//		int a = 1000000;
//		long b = 1000000L;
//		System.out.println(new Date(a*1000));
//		System.out.println(new Date(b*1000));
//		for(int i=0; i<10000; i++){
//			System.out.println(i);
//		}

//		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl("http://192.168.20.35:8080/api/v2/wallet/gng/list-wallet")
//				.queryParam("page", "1")
//				.queryParam("size", "10")
//				.queryParam("email", "");
//		ResponseEntity<String> response = getDataByUri(uriComponentsBuilder);
//		if (response.getStatusCode() != HttpStatus.OK) {
//			System.out.println("Error");
//		}
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
//		String json = response.getBody();
//		System.out.println(json);
//		System.out.println(mapper.readTree(json).get("status").asText());

		String[] myString = {};
		System.out.println(new HashSet<>(Arrays.asList(myString)).size());
	}

	@Bean
	public TaskScheduler taskScheduler() {
		final ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
		scheduler.setPoolSize(3);
		return scheduler;
	}

	private ResponseEntity<String> getDataByUri(UriComponentsBuilder builder) {
		// create an instance of RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		// create headers
		HttpHeaders headers = new HttpHeaders();
		// set `content-type` header
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBasicAuth("bitradez", "123456");
		HttpEntity<?> entity = new HttpEntity<>(headers);
		return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);
	}

}
