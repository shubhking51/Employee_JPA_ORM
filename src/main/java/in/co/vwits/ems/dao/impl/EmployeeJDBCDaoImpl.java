package in.co.vwits.ems.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import in.co.vwits.ems.dao.EmployeeDao;
import in.co.vwits.ems.model.Employee;

public class EmployeeJDBCDaoImpl implements EmployeeDao {

	// Save(Insert/Create-CRUD) data of employee
	public int save(Employee s) {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db", "root", "root");
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO tbl_employee VALUES(?,?,?,?)");) {
			pstmt.setInt(1, s.getId());
			pstmt.setString(2, s.getName());
			pstmt.setDouble(3, s.getSalary());
			pstmt.setString(4, s.getDepartment());
			int noOfRowsUpdated = pstmt.executeUpdate();// firing query...

			// System.out.println("No of records updated are "+ noOfRowSpaceUpdated);
			return noOfRowsUpdated;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	// Find All(Read-CRUD)
	
	  public List<Employee> findAll(){
	List<Employee> employees= new ArrayList<>();
	  try (Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db","root","root");
	  PreparedStatement pstmt = con.prepareStatement("SELECT * FROM tbl_employee");) 
	  {	  
	  ResultSet rs = pstmt.executeQuery();
	  while(rs.next()) {
		  Employee foundEmployee=new Employee();
		  foundEmployee.setId(rs.getInt(1));
		  foundEmployee.setName(rs.getString(2));
		  foundEmployee.setSalary(rs.getDouble(3));
		  foundEmployee.setDepartment(rs.getString(4));	 
		  employees.add(foundEmployee); 
	  }	  
	  } catch (SQLException e) {
		  e.printStackTrace(); 
		  } 
	  return employees; 
	  }
	  
	  //Find employee by employee id
	  public Optional<Employee> findByEmpId(int empId)
	             {
		         try (Connection con =
				  DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db","root",
				  "root"); PreparedStatement pstmt =
				  con.prepareStatement("SELECT * FROM tbl_employee WHERE EmpId= ?");)				 
				 {
		          Employee foundEmployee = new Employee();
		          pstmt.setInt(1, empId);
				 
				  ResultSet rs = pstmt.executeQuery();
				  if(rs.next()) {
					  foundEmployee.setId(rs.getInt(1));
					  foundEmployee.setName(rs.getString(2));
					  foundEmployee.setSalary(rs.getDouble(3));
					  foundEmployee.setDepartment(rs.getString(4));	 
					  
				  }
				  return Optional.of(foundEmployee); 
				  
				  }   
				  catch (SQLException e) { e.printStackTrace(); }
				  
				  return Optional.empty();
				  
				  }
	// Update(CRUD)
		
		  public void updateSalaryByEmpId(int empId, double modifiedSalary) { try
		  (Connection con =
		  DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db","root",
		  "root"); PreparedStatement pstmt =
		  con.prepareStatement("UPDATE tbl_employee SET Salary =? WHERE EmpId =?");
		  ) { 
			  pstmt.setDouble(1,modifiedSalary);
			  pstmt.setInt(2,empId);
		  
		  
		  int noOfRowSpaceUpdated = pstmt.executeUpdate();// firing query...
		  
		  System.out.println("No of records updated are "+ noOfRowSpaceUpdated); }
		  catch (SQLException e) { e.printStackTrace(); }
		  
		  }
		 
	 

	// Delete
	
	  public void deleteByEmpId(int empId)
	  { try(Connection con =
	  DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db","root",
	  "root");
	  PreparedStatement pstmt =	 con.prepareStatement("DELETE FROM tbl_employee WHERE EmpId = ?"); )
	  {
	  pstmt.setInt(1, empId);
	  int noOfRowsUpdated = pstmt.executeUpdate();
	  System.out.println("No of records affected are: "+  noOfRowsUpdated); }
	  catch (SQLException e) { e.printStackTrace(); } }
	
	// Sort By Name		
		  public List<Employee> findAllEmployeesSortedByName(){
		List<Employee> employees= new ArrayList<>();
		  try (Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db","root","root");
		  PreparedStatement pstmt = con.prepareStatement("SELECT * FROM tbl_employee ORDER BY Name");) 
		  {	  
		  ResultSet rs = pstmt.executeQuery();
		  while(rs.next()) {
			  Employee foundEmployee=new Employee();
			  foundEmployee.setId(rs.getInt(1));
			  foundEmployee.setName(rs.getString(2));
			  foundEmployee.setSalary(rs.getDouble(3));
			  foundEmployee.setDepartment(rs.getString(4));	 
			  employees.add(foundEmployee); 
		  }	  
		  } catch (SQLException e) {
			  e.printStackTrace(); 
			  } 
		  return employees; 
		  }
	// Sort By salary
		  public List<Employee> findAllEmployeesSortedBySalary(){
		List<Employee> employees= new ArrayList<>();
		  try (Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db","root","root");
		  PreparedStatement pstmt = con.prepareStatement("SELECT * FROM tbl_employee ORDER BY Salary");) 
		  {	  
		  ResultSet rs = pstmt.executeQuery();
		  while(rs.next()) {
			  Employee foundEmployee=new Employee();
			  foundEmployee.setId(rs.getInt(1));
			  foundEmployee.setName(rs.getString(2));
			  foundEmployee.setSalary(rs.getDouble(3));
			  foundEmployee.setDepartment(rs.getString(4));	 
			  employees.add(foundEmployee); 
		  }	  
		  } catch (SQLException e) {
			  e.printStackTrace(); 
			  } 
		  return employees; 
		  }

		@Override
		public void updateSalary(Employee s) {
			// TODO Auto-generated method stub
			
		}
	

	

}
