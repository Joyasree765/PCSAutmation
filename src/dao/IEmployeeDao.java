package dao;
import java.util.ArrayList;
import java.util.List;


import model.Employee;

public interface IEmployeeDao {
	ArrayList<Employee> getAllEmployees();
	void addEmployee(Employee emp);
	Employee getEmployeeById(int id);
	void updateEmployee(Employee emp);
	void deleteEmployee(int id);
	void deactivateEmployee(int id);
	//void deactivateEmployee(Employee emp);
	Employee checkLogin(String userId,String password);
	void activateEmployee(int id);
	

}
