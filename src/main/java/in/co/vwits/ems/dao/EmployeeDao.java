package in.co.vwits.ems.dao;

import java.util.List;
import java.util.Optional;

import in.co.vwits.ems.model.Employee;

public interface EmployeeDao {
	public List<Employee> findAll();
	public int save(Employee s);
	public Optional<Employee> findByEmpId(int empId);
//	public void updateSalaryByEmpId(int empId, double modifiedSalary);
	public void deleteByEmpId(int empId); 
	public List<Employee> findAllEmployeesSortedByName();
	public List<Employee> findAllEmployeesSortedBySalary();
	
	void updateSalary(Employee s);
	
	
}
