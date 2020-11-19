package dao;

import model.Employee;

public interface EmployeeDao {
	void getAllEmployee();
	void addEmployee(Employee emp);
	Employee getEmployeeById(int id);
	void updateEmployee(Employee emp);
	void deactiveEmployee(int id);
	void delectEmployee(int id);

}
