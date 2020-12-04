package view;
import java.awt.Container;
import java.sql.SQLException;
import javax.swing.JFrame;
import controller.EmploeeController;



public class ViewAllEmp extends JFrame {
	private EmploeeController empController;
	Container container=null;
	public ViewAllEmp() {
		container=getContentPane();
		try {
			empController=new EmploeeController();
			
		}
		catch(ClassNotFoundException e1){
			e1.printStackTrace();
			
		}
		catch(SQLException e1) {
			e1.printStackTrace();
		}
		empController.getAllEmployees();
		this.setTitle("Employee Details");
		this.setVisible(true);
		this.setBounds(10,10,500,1600);
		this.setResizable(false);
	}

}
