package in.co.vwits.ems.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.co.vwits.ems.dao.EmployeeDao;
import in.co.vwits.ems.dao.impl.EmployeeJDBCDaoImpl;
import in.co.vwits.ems.dao.impl.EmployeeJPADaoImpl;
import in.co.vwits.ems.model.Employee;
import in.co.vwits.ems.model.exception.EmployeeNotFoundException;
import in.co.vwits.ems.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	    private EmployeeDao dao;
	
		//Case 1:Find All
		 public List<Employee> findAll()
		 {
			 return dao.findAll(); 
		 }
		 
		//Case 2:Save for insert		
		public void save(Employee s) {
			dao.save(s);
		}
		//Case 3: Find employee by Emp id
		public Optional<Employee> findByEmpId(int empId) throws EmployeeNotFoundException {
			Optional<Employee> p=dao.findByEmpId(empId);
			if(p.isPresent()) {
				return p;
			}
			else {
				// throw user defined exception "StudentNotFound"
				throw new EmployeeNotFoundException();
			}

		}
		//Case 4 : Update Salary
		/*
		 * public void updateSalaryByEmpId(int empId, double modifiedSalary) {
		 * dao.updateSalaryByEmpId(empId,modifiedSalary); }
		 */
		//Case 5: Delete Record
		public void deleteByEmpId(int empId) {
			 dao.deleteByEmpId(empId);
		}
		//Case 6: Sorted by emp id
		public List<Employee> findAllEmployeesSortedByName(){
			return  dao.findAllEmployeesSortedByName(); }
		//case 7
		public List<Employee> findAllEmployeesSortedBySalary(){
			return  dao.findAllEmployeesSortedBySalary(); }
		
	
		public void updateSalary(Employee ss) {
			this.dao.updateSalary(ss);
			
		}
		
		
}
		



	


