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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.client.model.Customer;

@Controller
public class RestClientController {

	static final Logger logger = LogManager
			.getLogger(RestClientController.class.getName());

	private RestTemplate restTemplate = new RestTemplate();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getAll(Model model) {
		// logger.debug("Retrieve all persons");

		// Prepare acceptable media type

		// Prepare header
		// // Send the request as GET

		// Add to model

		// This will resolve to /WEB-INF/jsp/personspage.jsp
		// return "personspage";
		try {

			logger.error("erf");
			model.addAttribute("persons", restTemplate.getForObject(
					"http://localhost:9090/customer", Customer[].class));
			// System.out.println(person.toString());
			// System.out.println("Village Name: " + person.getName());
			// model.addAttribute("persons", result.getBody().getData());
			// model.addAllAttributes("person",)
			return "personspage";
		} catch (Exception e) {
			// System.out.println(logger.error(e.getMessage()));

			logger.error(e.getMessage());
			System.out.println(e.getMessage());
		}
		return "personspage";
	}

	/**
	 * Retrieves the JSP add page
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddPage(Model model) {
		logger.debug("Received request to show add page");

		// Create new Person and add to model
		// This is the formBackingOBject
		model.addAttribute("personAttribute", new Customer());

		// This will resolve to /WEB-INF/jsp/addpage.jsp
		return "addpage";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("personAttribute") Customer person,
			Model model) {
		logger.debug("Add new person");

		// Prepare acceptable media type
		// Send the request as POST
		try {
			// ResponseEntity<Person> result =
			// restTemplate.exchange("http://localhost:8080/spring-rest-provider/krams/person",
			// HttpMethod.POST, entity, Person.class);
			String url = "http://localhost:9090/customer";
			// Map<String, String> map = new HashMap<String, String>();
			// map.put("id", "111");
			// map.put("name", "Shyam");
			// Employee newEmp = new Employee(99, "guest", "guest@ibm.com");
			HttpEntity<Customer> entity = new HttpEntity<Customer>(person);
			ResponseEntity<Customer> response = restTemplate.postForEntity(
					"http://localhost:9090/customer", entity, Customer.class);
			Customer e = response.getBody();
			// handle the employee
			// ResponseEntity<Customer> entity= restTemplate.postForObject(url,
			// HttpMethod.POST, person);

			// System.out.println(entity.getBody().getName());
			// final String uri =
			// "http://localhost:8080/springrestexample/employees";

			// EmployeeVO newEmployee = new EmployeeVO(-1, "Adam", "Gilly",
			// "test@email.com");

			// RestTemplate restTemplate = new RestTemplate();
			// EmployeeVO result = restTemplate.postForObject( uri, newEmployee,
			// EmployeeVO.class);

			System.out.println(entity);
		} catch (Exception e) {
			logger.error(e);
		}

		// This will resolve to /WEB-INF/jsp/resultpage.jsp
		return "resultpage";
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String getPerson(@RequestParam("id") int id, Model model) {
		logger.debug("Retrieve person with id: " + id);
		// Prepare header
		// Send the request as GET
		try {
			// Add to model
			String url = "http://localhost:9090/customer/{id}";
			ResponseEntity<Customer> personEntity = restTemplate.getForEntity(
					url, Customer.class, id);
			model.addAttribute("person", personEntity.getBody());

			return "getpage";
		} catch (Exception e) {
			logger.error(e);
		}
		// This will resolve to /WEB-INF/jsp/getpage.jsp
		return "getpage";
	}

	/**
	 * Sends a delete request to the REST provider
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deletePerson(@RequestParam("id") int id, Model model) {
		logger.debug("Delete existing person");
		// Prepare acceptable media type

		// Prepare header
		// Send the request as DELETE
		// ResponseEntity<String> result =
		// restTemplate.exchange("http://localhost:8080/spring-rest-provider/krams/person/{id}",
		// HttpMethod.DELETE, entity, String.class, id);

		// This will resolve to /WEB-INF/jsp/resultpage.jsp
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:9090/customer/{id}";
		restTemplate.delete(url, id);
		return "resultpage";
	}
	/**
	 * Retrieves the JSP update page
	 */
	 @RequestMapping(value = "/update", method = RequestMethod.GET)
	   public String getUpdatePage(@RequestParam(value="id", required=true) Integer id,  
	             Model model) {
	    logger.debug("Received request to show edit page");
	    
	    // Retrieve existing Person and add to model
	    // Prepare acceptable media type
	 List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
	 acceptableMediaTypes.add(MediaType.APPLICATION_XML);
	  
	 // Prepare header
	 HttpHeaders headers = new HttpHeaders();
	 headers.setAccept(acceptableMediaTypes);
	 HttpEntity<Customer> entity = new HttpEntity<Customer>(headers);
	 
	 // Send the request as GET
	 try {
	  ResponseEntity<Customer> result = restTemplate.exchange("http://localhost:9090/customer/{id}", HttpMethod.GET, entity, Customer.class, id);
	  // Add to model
	  model.addAttribute("personAttribute", result.getBody());
	   
	 } catch (Exception e) {
	  logger.error(e);
	 }
	     
	    // This will resolve to /WEB-INF/jsp/updatepage.jsp
	    return "updatepage";
	}
}
