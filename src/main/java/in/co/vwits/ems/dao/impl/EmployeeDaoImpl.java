package in.co.vwits.ems.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.text.html.HTMLDocument.Iterator;

import in.co.vwits.ems.model.Employee;

public class EmployeeDaoImpl {
private List<Employee> employees;
	
	public EmployeeDaoImpl() {
		employees = new ArrayList<Employee>();
		Employee e1= new Employee();
		e1.setId(1);
		e1.setName("Amisha");
		e1.setSalary(50000);
		e1.setDepartment("KD");
				
		Employee e2= new Employee();
		e2.setId(2);
		e2.setName("Aman");
		e2.setSalary(60000);
		e2.setDepartment("Engineering");
		
		Employee e3= new Employee();
		e3.setId(3);
		e3.setName("Simran");
		e3.setSalary(55000);
		e3.setDepartment("Trucks");
		
		
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		
	}
		public List<Employee> findAll(){
			return employees;
		}
		public void save(Employee s) {
			employees.add(s);
		}
		
		public Optional<Employee> findByEmpId(int empId) {
			for(Employee s:employees) {
				if(s.getId()==empId) {
					return Optional.of(s);				
				}
			}
			return Optional.empty();
			
			
		}
		 public void updateByRollno(int empId, double modifiedSalary)
		 { for(Employee s:employees) {
			 if(s.getId()==empId) { s.setSalary(modifiedSalary); } }
		 }
			
}
