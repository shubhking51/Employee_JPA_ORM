package in.co.vwits.ems.service;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import in.co.vwits.ems.model.Employee;
import in.co.vwits.ems.model.exception.EmployeeNotFoundException;

public interface EmployeeService {	

		void save(Employee s);
		List<Employee> findAll();
		Optional<Employee> findByEmpId(int rollno) throws EmployeeNotFoundException;
		void updateSalary(Employee ss);
		void deleteByEmpId(int empId);
		List<Employee> findAllEmployeesSortedByName();
		List<Employee> findAllEmployeesSortedBySalary();
		
	

	}
