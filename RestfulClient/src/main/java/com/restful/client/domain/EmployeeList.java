package com.restful.client.domain;

import java.util.List;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

@JsonDeserialize
public class EmployeeList {
	private List<Employee> empData;

	public List<Employee> getEmpData() {
		return empData;
	}

	public void setEmpData(List<Employee> empData) {
		this.empData = empData;
	}
}
