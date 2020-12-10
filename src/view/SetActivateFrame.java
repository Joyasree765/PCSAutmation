package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;

import controller.EmploeeController;



public class SetActivateFrame extends JFrame {
	Container container;
	JFrame f;
	JLabel IEmployeeId;
	JTextField tEmployeeId;
	JButton bActive;
	EmploeeController empController=null;
	public SetActivateFrame() throws ClassNotFoundException,SQLException {
		container=getContentPane();
		f=new JFrame();
		IEmployeeId=new JLabel("Employee ID");
		bActive=new JButton("ACTIVATE");
		empController=new EmploeeController();
		bActive.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int s;
				s=tEmployeeId.getColumns();
				f=new JFrame();
				//empController.activateEmployee(s);
				JOptionPane.showMessageDialog(f,"Employee Activate...");
				
			}
			
		});
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("Activate Employee");
		this.setVisible(true);
		this.setBounds(10,10,500,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		
		
	}
	public void setLayoutManager() {
		container.setLayout(null);
	}
	public void setLocationAndSize() {
		IEmployeeId.setBounds(50, 80, 300, 30);
		tEmployeeId.setBounds(50, 150, 100, 30);
		bActive.setBounds(50, 250, 100, 30);
		
	}
	public void addComponentsToContainer() {
		container.add(IEmployeeId);
		container.add(tEmployeeId);
		container.add(bActive);
	
	}

}
