package com.perscholas;

import com.perscholas.models.Employees;
import com.perscholas.service.EmployeeService;

public class MainRunner {

	public static void main(String[] args) {
Employees employees = new Employees(9000, "Stranger", "Danger", "x8670","Dangerous@gmail.com", "7",1088,  "Sales Manager",90);

			EmployeeService es = new EmployeeService();
			System.out.println(es.updateEmployee(employees));
			System.out.println(es.PrendsEmployees(1088));
		    System.out.println(es.getAllEmployees());
			//System.out.println(es.deleteEmployee(9000));
	}

}
