package com.restful.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.restful.app.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	private static List<Employee> employees = new ArrayList<Employee>();

	static {
		employees.add(new Employee(1, "Shamal", "Mahesh", 26, "Kurunegala", 10000.12));
		employees.add(new Employee(2, "Mahesh", "Rathnayaka", 23, "Colombo", 22600.12));
		employees.add(new Employee(3, "Jeewana", "Kasun", 22, "Colombo", 32600.12));
		employees.add(new Employee(4, "Nipuna", "Ranasinghe", 24, "Colombo", 42600.12));
		employees.add(new Employee(5, "Tharanga", "Shanika", 27, "Colombo", 52600.12));
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Employee> getAllEmployees() {
		return employees;
	}

	@RequestMapping(value = "/{eid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Employee getEmployee(@PathVariable("eid") Integer eid) {
		for (Employee emp : employees) {
			if (emp.getEid().equals(eid)) {
				return emp;
			}
		}
		return null;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void addEmployee(@RequestBody Employee employee) {
		employees.add(employee);
	}

	@RequestMapping(value = "/{eid}", method = RequestMethod.PUT)
	@ResponseBody
	public Employee updateEmployee(@PathVariable("eid") Integer eid, @RequestBody Employee employee) {
		for (Employee emp : employees) {
			if (emp.getEid().equals(eid)) {
				emp.setFirstName(employee.getFirstName());
			}
		}
		return employee;
	}

	@RequestMapping(value = "/{eid}", method = RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable("eid") Integer eid) {
		Employee rEmployee = null;
		for (Employee emp : employees) {
			if (emp.getEid().equals(eid)) {
				rEmployee = emp;
			}
		}
		if (rEmployee == null) {
		} else {
			employees.remove(rEmployee);
		}
	}
}
