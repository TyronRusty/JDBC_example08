package com.perscholas.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.perscholas.dao.EmployeeDAO;
import com.perscholas.dto.EmployeeDTO;
import com.perscholas.models.Employees;

public class EmployeeService implements EmployeeDAO{
	
	 static final String DB_URL = "jdbc:mysql://localhost:3306/classicmodels";
	 static final String USER = "root";
	 static final String PASS = "root";
	

	@Override
	public int createEmployee(Employees employees) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int InsertEmployees(){
	
		// establish the connect 
		try(Connection conn = DriverManager.getConnection(DB_URL,USER,PASS); ){
			System.out.println("connection is successful!");
String sqlQuery = "INSERT INTO EMPLOYEES (employeeNumber,firstName,lastName,extension,email,OfficeCode,reportsTo,jobTitle,VacationHours) VALUES (?,?,?,?,?,?,?,?,?)";
PreparedStatement prepStmt = conn.prepareStatement(sqlQuery);
prepStmt = conn.prepareStatement(sqlQuery);
prepStmt.setInt(1, 9000);
prepStmt.setString(2, "Jamil");
prepStmt.setString(3, "fink");
prepStmt.setString(4,"X543");
prepStmt.setString(5, "JJ@gmail.com");
prepStmt.setString(6, "3");
prepStmt.setInt(7, 1056);
prepStmt.setString(8, "Sales Rep");
prepStmt.setInt(9, 60);
int affectedRows = prepStmt.executeUpdate();
System.out.println(affectedRows + " row(s) affected !!");



		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return 0;
		
		
	}
	public List<Employees> PrendsEmployees(int id){
		List<Employees> listEmp = new ArrayList<>();
		// establish the connect 
		try(Connection conn = DriverManager.getConnection(DB_URL,USER,PASS); ){
			System.out.println("connection is successful!");
			PreparedStatement prepStmt = conn.prepareStatement ("select * from employees where employeeNumber = ? ");
			prepStmt.setInt(1, id);
			ResultSet rs = prepStmt.executeQuery();
			while(rs.next()) {
				
				//int employeeNumber, String lastName, String firstName, String extension, String email,
				// String officeCode, int reportsTo, String jobTitle, int vacationHours
				Employees e =new Employees(
						rs.getInt("employeeNumber"),
						rs.getString("lastName"),
						rs.getString("firstName"),
						rs.getString("extension"),
						rs.getString("email"),
						rs.getString("officeCode"),
						rs.getInt("reportsTo"),
						rs.getString("jobTitle"),
						rs.getInt("VacationHours")
						
						);
				// add object into list 
				listEmp.add(e);
			
			}
			
	
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return listEmp ;
		
		
	}
	@Override
	public List<Employees> getAllEmployees() {
		
		List<Employees> listEmp = new ArrayList<>();
		// connection 
		try(Connection conn = DriverManager.getConnection(DB_URL,USER,PASS); ){
			
			// prepared statement 
				PreparedStatement ps = conn.prepareStatement("select * from employees where employeeNumber = 1002");
			// result set 
				ResultSet rs = ps.executeQuery();
			// convert result set to employee object
				while(rs.next()) {
					
					//int employeeNumber, String lastName, String firstName, String extension, String email,
					// String officeCode, int reportsTo, String jobTitle, int vacationHours
					Employees e =new Employees(
							rs.getInt("employeeNumber"),
							rs.getString("lastName"),
							rs.getString("firstName"),
							rs.getString("extension"),
							rs.getString("email"),
							rs.getString("officeCode"),
							rs.getInt("reportsTo"),
							rs.getString("jobTitle"),
							rs.getInt("VacationHours")
							
							);
					// add object into list 
					listEmp.add(e);
				
				}
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		
		
		
		
		return listEmp;
	}

@Override
	public int updateEmployee (Employees employees) {

		
	try(Connection conn = DriverManager.getConnection(DB_URL,USER,PASS); ){
			
			// prepared statement 
		// only the info that are selected will be changed 
				PreparedStatement ps = conn.prepareStatement("UPDATE employees set firstName =?, lastName =? where employeeNumber = ?");
				ps.setString(1, employees.getFirstName());
				ps.setString(2, employees.getLastName());
				ps.setLong(3, employees.getEmployeeNumber());
				return ps.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteEmployee(int empId) {
	
	
try(Connection conn = DriverManager.getConnection(DB_URL,USER,PASS); ){
			
			// prepared statement 
				PreparedStatement ps = conn.prepareStatement("DELETE from employees WHERE employeeNumber = ?");
			// result set 
			//	ResultSet rs = ps.executeQuery();
			ps.setInt(1, empId);
			int rows = ps.executeUpdate();
			
			System.out.println(rows+ " row affected");
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return 0;
	}
	
	public List<EmployeeDTO> getEmployeeEmails(){
		
		List<EmployeeDTO> listEmp = new ArrayList<>();
		// connection 
		try(Connection conn = DriverManager.getConnection(DB_URL,USER,PASS); ){
			
			// prepared statement 
				PreparedStatement ps = conn.prepareStatement("select * from employees");
			// result set 
				ResultSet rs = ps.executeQuery();
			// convert result set to employee object
				while(rs.next()) {
					
					//int employeeNumber, String lastName, String firstName, String extension, String email,
					// String officeCode, int reportsTo, String jobTitle, int vacationHours
					EmployeeDTO e =new EmployeeDTO(
							rs.getInt("employeeNumber"),
							rs.getString("email")
							);
					// add object into list 
					listEmp.add(e);
				
				}
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		
		
		
		
		return listEmp;
		
	}
	
	

}
