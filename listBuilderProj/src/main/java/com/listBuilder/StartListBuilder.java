package com.listBuilder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
//@ComponentScan({"com.listBuilder.back"})
//@EntityScan("com.listBuilder.back")
//@EnableJpaRepositories("com.listBuilder.back")
public class StartListBuilder extends SpringBootServletInitializer {

	public static void main(String[] args) {
		System.out.println("TEST_PRINT");
		SpringApplication.run(StartListBuilder.class, args);
	  
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	    return builder.sources(StartListBuilder.class);
	}

}
