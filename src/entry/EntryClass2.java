package entry;
import java.sql.SQLException;
import java.util.Scanner;

import config.JDBCConnection;
import controller.JobController;

public class EntryClass2 {
	public static void testConnection() throws ClassNotFoundException, SQLException {
		if(JDBCConnection.getDBConnection().isClosed()) {
			System.out.println("Connection is closed");
		}
		else {
			System.out.println("Connection is opened");
		}
		

	}
	@SuppressWarnings("resource")
	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
		//EntryClass entr=new EntryClass();
				//entr.testConnection();
				JobController jbController=new JobController();
				Scanner sc=new Scanner(System.in);
				int option;
				char ch='y';
				while(ch=='y'|| ch=='y'){
					System.out.println("CRUD Operation Detail:");
					System.out.println("1. view all Jobs record");
					System.out.println("2. view single Jobs record");
					System.out.println("3. Add an Job");
					System.out.println("4. Update an Jobs record");
					System.out.println("5. Deactive an  Jobs record");
					System.out.println("6. Delect an Jobs record");
					System.out.println("7. Exit");
					System.out.println("Enter your choice:");
					option=sc.nextInt();
					switch(option) {
					case 1:
						System.out.println("Folling are all Job Detail:");
						jbController.getAllJobs();
						break;
					case 2:
						jbController.getJobById();
						break;
					case 3:
						System.out.println("Enter Job Detail:");
						jbController.addJob();
						break;
					case 4:
						jbController.updateJob();
						break;
					case 5:
						jbController.deactiveJob();
						break;
					case 6:
						jbController.deleteJob();
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
