package com.sharism.blog_server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
@MapperScan("com.sharism.blog_server.mapper")//将项目中对应的mapper类的路径加进来就可以了
@SpringBootApplication
public class BlogServerApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BlogServerApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(BlogServerApplication.class, args);
	}
}
