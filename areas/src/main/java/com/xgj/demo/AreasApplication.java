package com.xgj.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.xgj.demo.mapper")
@SpringBootApplication
public class AreasApplication {

	public static void main(String[] args) {
		SpringApplication.run(AreasApplication.class, args);
	}
}
