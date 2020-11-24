package entry;
import java.sql.SQLException;
import java.util.Scanner;

import config.JDBCConnection;
import controller.EmploeeController;

public class EntryClass {

	public static void testConnection() throws ClassNotFoundException, SQLException {
		if(JDBCConnection.getDBConnection().isClosed()) {
			System.out.println("Connection is closed");
		}
		else {
			System.out.println("Connection is opened");
		}
		

	}
	@SuppressWarnings("resource")
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//EntryClass entr=new EntryClass();
		//entr.testConnection();
		EmploeeController empController=new EmploeeController();
		Scanner sc=new Scanner(System.in);
		int option;
		char ch='y';
		while(ch=='y'|| ch=='y'){
			System.out.println("CRUD Operation Detail:");
			System.out.println("1. view all Employees record");
			System.out.println("2. view single Employees record");
			System.out.println("3. Add an Employee");
			System.out.println("4. Update an Employees record");
			System.out.println("5. Deactive an  Employees record");
			System.out.println("6. Delect an Employees record");
			System.out.println("7. Exit");
			System.out.println("Enter your choice:");
			option=sc.nextInt();
			switch(option) {
			case 1:
				System.out.println("Folling are all Employee Detail:");
				empController.getAllEmployees();
				break;
			case 2:
				empController.getEmployeeById();
				break;
			case 3:
				System.out.println("Enter Employee Detail:");
				empController.addEmployee();
				break;
			case 4:
				empController.updateEmployee();
				break;
			case 5:
				empController.deactiveEmployee();
				break;
			case 6:
				empController.deleteEmployee();
				break;
				
			case 7:
				System.exit(0);
				
				break;
				default:
					System.out.println("wrong input");
					
				
				
			
			}
			System.out.println("Do you want to continue?(y/n)");
			ch=sc.next().charAt(0);
			

			
		}
		
	}

}
