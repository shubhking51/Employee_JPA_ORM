import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.co.vwits.ems.ApplicationConfiguration;
import in.co.vwits.ems.model.Employee;
import in.co.vwits.ems.model.exception.EmployeeNotFoundException;
import in.co.vwits.ems.service.EmployeeService;
import in.co.vwits.ems.service.impl.EmployeeServiceImpl;

public class TestEmployee {
	
		// TODO Auto-generated method stub
		public static void main(String[] args) {
			ApplicationContext container;
			
			//Below line is instantiating spring container
			container= new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
			EntityManagerFactory factory = container.getBean(EntityManagerFactory.class);
			System.out.println(factory);
			Scanner sc = null;	
			
			try {
				sc=new Scanner(System.in);
				EmployeeService service = container.getBean(EmployeeService.class);
				int option=1;
			//Show all students
		do {
				System.out.println("---------Welcome to Employee mangement----------");
				System.out.println("1 Find/Read all records present");
				System.out.println("2 Insert Records of employee");
				System.out.println("3 Find employee by Emp Id");				
				System.out.println("4 Update employee Salary");
				System.out.println("5 Delete record of an employee");
				
				System.out.println("6 Sort employees by Name");
				System.out.println("7 Sort employees by Salary");
				
				System.out.println("-1 to Exit");
				System.out.println("Enter choice");
				
				option= sc.nextInt();
				
				switch(option) {
				// Show/Read all record (CRUD)
				case 1:
					List<Employee> employee = service.findAll();
				   System.out.println(employee);
				    break;
				// Insert/Create Record(CRUD)
				case 2:
					
					Employee s= new Employee();
									
					System.out.println("Enter Name of Employee:");
					s.setName(sc.next());
					System.out.println("Enter Salary of Employee:");
					s.setSalary(sc.nextInt());
					System.out.println("Enter Departmrnt of Employee: ");
					s.setDepartment(sc.next());	
					service.save(s);
					System.out.println("Data Saved");
					
					break;
				//Find/Read By Emp id(CRUD)
				case 3:
					System.out.println("Enter the Employee Id.");
					int empId=sc.nextInt();
					Optional<Employee> foundEmployee;
					try {
					    foundEmployee = service.findByEmpId(empId);
						System.out.println("Found Employee "+foundEmployee.get());
					} catch (EmployeeNotFoundException e) {
				      	System.out.println("Employee Not Found");
					}
					
					break;
					//Update employee salary(CRUD)
				case 4:				
		            double modifiedSalary;
				    System.out.println("Enter the Employee Id");
				    empId=sc.nextInt();
					try {
						foundEmployee = Optional.ofNullable(service.findByEmpId(empId).get());
						Employee ss= foundEmployee.get();
						System.out.println("Enter new salary");
						modifiedSalary=sc.nextDouble();
						ss.setSalary(modifiedSalary);
						service.updateSalary(ss);
						System.out.println("Salary Updated");
					} catch (EmployeeNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				  break;		
			
				  //Delete record of an employee(CRUD)
				case 5: System.out.println("Enter the employee Id.");
				      try {
					  empId=sc.nextInt();
					  service.deleteByEmpId(empId); }
					  catch(InputMismatchException e) {
					  System.out.println("Emp Id must be an Integer value"); sc.nextLine();
					  //This statement is used to discard the input
					 
					  }    
					  break;
				//Sort employees by name in ascending order 
				case 6:
					System.out.println(service.findAllEmployeesSortedByName());
					  break;
				
				//Sort employees by salary in ascending order
				case 7:
					  System.out.println(service.findAllEmployeesSortedBySalary());
					  break;
					  
						
				case -1:
					System.out.println("--------------------Thank You---------------------");
					break;
					
				}
				
			}while(option!=-1);
			}
			finally {
				sc.close();
			}

	}

}
