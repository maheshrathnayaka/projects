package com.rest.client.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.rest.client.model.Employee;

@Controller
public class ClientController {
	static final Logger logger = LogManager.getLogger(ClientController.class.getName());
	private RestTemplate restTemplate = new RestTemplate();

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String getAllEmployees(Model model) {
		try {
			// RestTemplate restTemplate = new RestTemplate();
			logger.debug("----- Show home page (All Employees) -----");
			String url = "http://localhost:9090/employees";
			model.addAttribute("employees", restTemplate.getForObject(url, Employee[].class));
			return "employees_page";
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "employees_page";
	}

	@RequestMapping(value = "/add_employee", method = RequestMethod.GET)
	public String getAddPage(Model model) {
		logger.debug("----- Show add page -----");
		model.addAttribute("employeeAttribute", new Employee());
		return "add_employee_page";
	}

	@RequestMapping(value = "/add_employee", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("employeeAttribute") Employee employee, Model model) {
		try {
			logger.debug("----- New employee added -----");
			String url = "http://localhost:9090/employees";
			HttpEntity<Employee> entity = new HttpEntity<Employee>(employee);
			ResponseEntity<Employee> response = restTemplate.postForEntity(url, entity, Employee.class);
			Employee emp = response.getBody();
		} catch (Exception e) {
			logger.error(e);
		}
		return "resultpage";
	}
}
