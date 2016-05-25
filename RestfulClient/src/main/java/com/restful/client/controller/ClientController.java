package com.restful.client.controller;

import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.restful.client.domain.Employee;

public class ClientController {
	protected static Logger logger = Logger.getLogger("controller");
	private RestTemplate restTemplate = new RestTemplate();

	@RequestMapping(value = "/getall")
	public String getAll(Model model) {
		try{
			 RestTemplate restTemplate = new RestTemplate();
			 logger.error("erf");
			 model.addAttribute("employees",restTemplate.getForObject("http://localhost:1990/employees", Employee[].class));
			//System.out.println(person.toString());
			 System.out.println("Village Name:    ");  
			 return "employeepage";
		 }catch(Exception e)
		 {
			//System.out.println(logger.error(e.getMessage())); 
			
			logger.error(e.getMessage());
			 System.out.println(e.getMessage());
		 }
		return "employeepage";
	}
}
