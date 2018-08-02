package com.xgj.amqp;

import com.xgj.demo.dao.AutoIdUtil;
import com.xgj.demo.model.Config;
import com.xgj.demo.model.IdUser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MyAmqpApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAmqpApplication.class, args);
//		Config config = new Config();
//		IdUser id = config.get();
//		AutoIdUtil util = new AutoIdUtil();
//		ConfigurableApplicationContext context =SpringApplication.run(MyAmqpApplication.class,args);
//		IdUser id = context.getBean(IdUser.class);
//		IdUser id = new IdUser();
//		System.out.println(id);
	}
}
