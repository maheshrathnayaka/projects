package com.restful.app.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan("com.restful.app.controller")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
