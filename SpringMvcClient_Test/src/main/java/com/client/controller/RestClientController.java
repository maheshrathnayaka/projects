package com.client.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.client.model.Customer;
@Controller
public class RestClientController {
	
	 static final Logger logger = LogManager.getLogger(RestClientController.class.getName());

	private RestTemplate restTemplate = new RestTemplate();
	
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	 public String getAll(Model model) {
	// logger.debug("Retrieve all persons");
	   
//	  // Prepare acceptable media type
//	  List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
//	  acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
//	   System.out.println("*****");
//	  // Prepare header
//	  HttpHeaders headers = new HttpHeaders();
//	  headers.setAccept(acceptableMediaTypes);
//	  HttpEntity<Customer> entity = new HttpEntity<Customer>(headers);
//	  System.out.println("*****");
//	  // Send the request as GET
//	  try {
//	   ResponseEntity<Customer> result = restTemplate.exchange("http://localhost:9090/customer", HttpMethod.GET, entity,Customer.class);
//	   System.out.println("***result"+result.getBody());
//	   // Add to model
//	 // model.addAttribute("persons", result.getBody());
//	    
//	  } catch (Exception e) {
//	   logger.error(e);
//	  }
//	   
//	  // This will resolve to /WEB-INF/jsp/personspage.jsp
//	  return "personspage";
	 try{
		 RestTemplate restTemplate = new RestTemplate();
		 logger.error("erf");
		 model.addAttribute("person",restTemplate.getForObject("http://localhost:9090/customer", Customer[].class));
		//System.out.println(person.toString());
		// System.out.println("Village Name:    " + person.getName());  
		 return "view";
	 }catch(Exception e)
	 {
		//System.out.println(logger.error(e.getMessage())); 
		
		logger.error(e.getMessage());
		 System.out.println(e.getMessage());
	 }
	return "view";
	 
	 
	 
	 
	 }
}
