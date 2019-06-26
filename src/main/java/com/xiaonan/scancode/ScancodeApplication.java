package com.xiaonan.scancode;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


//@SpringBootApplication
//@MapperScan(basePackages = "com.xiaonan.scancode.dao.mapper")
//public class ScancodeApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(ScancodeApplication.class, args);
//	}
//
//}

@SpringBootApplication
@MapperScan(basePackages = "com.xiaonan.scancode.dao.mapper")
public class ScancodeApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ScancodeApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ScancodeApplication.class);
	}
}