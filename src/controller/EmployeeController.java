package controller;
import java.io.*;
import model.Employee;

public class EmployeeController {
	public Employee addEmployee() {
		Employee emp=new Employee();
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter FirsyName");
			emp.setFirsyName(reader.readLine());
			System.out.println("Enter lastName");
			emp.setLastName(reader.readLine());
			System.out.println("Enter UserId");
			emp.setUserId(reader.readLine());
			System.out.println("Enter Password");
			emp.setPassword(reader.readLine());
			System.out.println("Enter Role");
			String Role=reader.readLine();
			emp.setRole(Role);
			System.out.println("Enter Gender");
			emp.setGender(reader.readLine());
			if(Role.equals("HRA")) {
				emp.setActive("active");
				
			}
			else {
				emp.setActive("Deactive");
			}
		}
		catch(IOException ex) {
			System.out.println(ex.getMassage());
		}
		return emp;
		
	}

}
