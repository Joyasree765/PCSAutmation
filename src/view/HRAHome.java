package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HRAHome extends JFrame {
	Container container=null;
	JLabel lTitle;
	JButton bSetActive,bSetDeactive,bViewAllEmp, bViewSelectiveEmp, bAddSkill, bViewSkill, bSetDeactiveSkill, bLogout;
	public HRAHome() {
		container=getContentPane();
		lTitle=new JLabel("Welcome to HRA portal");
		bSetActive=new JButton("Activate Users");
		bSetActive.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new SetActivateFrame();
				
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
				// TODO Auto-generated method stub
				
			}
			
		});
		bViewSkill=new JButton("View all Skills");
		bViewSkill.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
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
