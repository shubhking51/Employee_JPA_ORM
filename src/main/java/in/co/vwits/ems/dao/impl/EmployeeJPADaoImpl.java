package in.co.vwits.ems.dao.impl;
import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import in.co.vwits.ems.dao.EmployeeDao;
import in.co.vwits.ems.model.Employee;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class EmployeeJPADaoImpl implements EmployeeDao{

	
	@PersistenceContext
	private EntityManager em;
	
	//save method
	@Override
	public int save(Employee s) {
		
		em.persist(s); 
		return 1;
		
	}
	
	//Find by employee id
	public Optional<Employee> findByEmpId(int empId) {
		
		Employee s = em.find(Employee.class, empId);
		return Optional.of(s);
		
	}
	//Find all
	@Override
	public List<Employee> findAll() {
		String jpql="FROM Employee";
		TypedQuery<Employee> query = em.createQuery(jpql,Employee.class);
		List<Employee> employeeList = query.getResultList();
		return employeeList;
	}
	
	// Delete employee by their employee id
	@Override
	public void deleteByEmpId(int empId) {
		em.remove(em.find(Employee.class, empId)); 
				
	}
	
	//update 
	/*
	 * public void updateByRollno(int empId, double modifiedSalary) { // TODO
	 * Auto-generated method stub EntityManager em = factory.createEntityManager();
	 * EntityTransaction tx = em.getTransaction(); tx.begin(); Employee s= new
	 * Employee(); s.setId(empId); s.setSalary(modifiedSalary); em.merge(s); //this
	 * fires update query tx.commit(); em.close();
	 * }
	 */
	
	public void updateSalary(Employee s) {
			
		em.merge(s); 
		}
	
	@Override
	public List<Employee> findAllEmployeesSortedByName() {
		
		String jpql="FROM Employee ORDER BY name";
		TypedQuery<Employee> query = em.createQuery(jpql,Employee.class);
		List<Employee> employeeList = query.getResultList();
		return employeeList;
	
	}
	@Override
	public List<Employee> findAllEmployeesSortedBySalary() {
		String jpql="FROM Employee ORDER BY salary";
		TypedQuery<Employee> query = em.createQuery(jpql,Employee.class);
		List<Employee> employeeList = query.getResultList();
		return employeeList;
	}

	/*public void updateSalaryByEmpId(int empId, double modifiedSalary) {
		// TODO Auto-generated method stub
		
	}
*/
}



