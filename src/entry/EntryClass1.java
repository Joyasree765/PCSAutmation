package entry;
import java.sql.SQLException;
import java.util.Scanner;

import config.JDBCConnection;
import controller.SkillController;

public class EntryClass1 {
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
				SkillController skController=new SkillController();
				Scanner sc=new Scanner(System.in);
				int option;
				char ch='y';
				while(ch=='y'|| ch=='y'){
					System.out.println("CRUD Operation Detail:");
					System.out.println("1. view all Skills record");
					System.out.println("2. view single Skills record");
					System.out.println("3. Add an Skill");
					System.out.println("4. Update an Skills record");
					System.out.println("5. Deactive an  Skills record");
					System.out.println("6. Delect an Skills record");
					System.out.println("7. Exit");
					System.out.println("Enter your choice:");
					option=sc.nextInt();
					switch(option) {
					case 1:
						System.out.println("Folling are all Skill Detail:");
						skController.getAllSkills();
						break;
					case 2:
						skController.getSkillById();
						break;
					case 3:
						System.out.println("Enter Skill Detail:");
						skController.addSkill();
						break;
					case 4:
						skController.updateSkill();
						break;
					case 5:
						skController.deactiveSkill();
						break;
					case 6:
						skController.deleteSkill();
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
