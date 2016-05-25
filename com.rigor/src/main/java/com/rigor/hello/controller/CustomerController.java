package com.rigor.hello.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rigor.hello.model.Customer;

@Controller
@RequestMapping("/customers")

public class CustomerController {
	private static List<Customer> list = new ArrayList<Customer>();
	static {
		list.add(new Customer(1l, "Mahesh"));
		list.add(new Customer(2l, "Shamal"));
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Customer> getAllCustomers() {
		return list;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.ALL_VALUE)
	@ResponseBody
	public Customer getCustomer(@PathVariable("id") Long id) {
		for (Customer c : list) {
			if (c.getId().equals(id)) {
				return c;
			}
		}
//		throw new CustomerNotFoundException();
		return null;
	}

	@RequestMapping(value = "/abc", method = RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void addCustomer(@RequestBody Customer customer) {
		
	System.out.println(customer);
		list.add(customer);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Customer updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer) {
		for (Customer c : list) {
			if (c.getId().equals(id)) {
				c.setName(customer.getName());
			}
		}
		return customer;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteCustomer(@PathVariable("id") Long id) {
		Customer rCustomer = null;
		for (Customer c : list) {
			if (c.getId().equals(id)) {
				rCustomer = c;
			}
		}
		if (rCustomer == null) {
//			throw new CustomerNotFoundException();
		}else{
			list.remove(rCustomer);
		}
	}
}
