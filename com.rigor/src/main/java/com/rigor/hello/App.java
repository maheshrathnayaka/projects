package com.rigor.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan("com.rigor.hello")
public class App {
	public static void main(String[] args){
		SpringApplication.run(App.class, args);
	}
}
