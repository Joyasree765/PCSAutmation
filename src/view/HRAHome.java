package view;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import controller.EmploeeController;
import controller.JobController;
import controller.SkillController;
import model.Employee;

public class HRAHome extends JFrame {
	Container container;
	JLabel lTitle,lEmpId;
	JTextField tEmpId,tData;
	JList list;
	//DefaultListModel<List<Employee>>listmodel;
	JButton bSetActive,bSetDeactive,bViewAllEmp, bViewSelectiveEmp, bAddSkill, bViewSkill, bSetDeactiveSkill, bLogout;
	JFrame f;
	EmploeeController empController=null;
	JobController jobController=null;
	SkillController skillController=null;
	
	public HRAHome()  throws ClassNotFoundException,SQLException {
		container=getContentPane();
		empController=new EmploeeController();
		jobController=new JobController();
		skillController=new SkillController();
		lTitle=new JLabel("Welcome to HRA portal");
		tEmpId=new JTextField();
		Employee emp=new Employee();
		bSetActive=new JButton("Activate Users");
		bSetActive.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				new SetActivateFrame();
				
			}catch(ClassNotFoundException e1) {
				e1.printStackTrace();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
			}	
		});
		bSetDeactive=new JButton("Deactivate Users");
		bSetDeactive.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
								
			}
		});
		bViewAllEmp=new JButton("View all Employees");
		bViewAllEmp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
								
			}
		});
		bViewSelectiveEmp=new JButton("View selective Employees");
		bViewSelectiveEmp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		bAddSkill=new JButton("Add Skill");
		bAddSkill.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new AddSkillFrame();
					
				}catch(ClassNotFoundException e1) {
					e1.printStackTrace();
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
				}	
				
						
			
		});
		bViewSkill=new JButton("View all Skills");
		bViewSkill.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
			
		});
		bSetDeactiveSkill=new JButton("Deactive Skill");
		bSetDeactiveSkill.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		bLogout=new JButton("Logout");
		bLogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
				
				
				
				
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("HRA Home Screen");
		this.setVisible(true);
		this.setBounds(10,10,500,1600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	public void setLayoutManager() {
		container.setLayout(null);
	}
	public void setLocationAndSize() {
		lTitle.setBounds(50, 100, 300, 30);
		bSetActive.setBounds(50, 150, 300, 30);
		bSetDeactive.setBounds(50, 200, 300, 30);
		bViewAllEmp.setBounds(50, 250, 300, 30);
		bViewSelectiveEmp.setBounds(50, 300, 300, 30);
		bAddSkill.setBounds(50, 350, 300, 30);
		bViewSkill.setBounds(50, 400, 300, 30);
		bSetDeactiveSkill.setBounds(50, 450, 300, 30);
		bLogout.setBounds(50, 500, 300, 30);
			
	}
	public void addComponentsToContainer() {
		container.add(bSetActive);
		container.add(bSetDeactive);
		container.add(bViewAllEmp);
		container.add(bViewSelectiveEmp);
		container.add(bAddSkill);
		container.add(bViewSkill);
		container.add(bSetDeactiveSkill);
		container.add(bLogout);
		
	}

}
