package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import controller.EmploeeController;
import model.Employee;

public class EMPHome extends JFrame{

	Container container=null;
	JLabel lTitle;
	JButton bViewprofile,bUpdateProfile,bUpdateSkill,bApplyJob,bLogout;
	private EmploeeController empController;
	public EMPHome(Employee emp) {
		container=getContentPane();
		try {
			empController=new EmploeeController();
		}
		catch(ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		catch(SQLException e1) {
			e1.printStackTrace();
			
		}
		
		lTitle=new JLabel("welcome toEmployee portal");
		bViewprofile= new JButton("view profile");
		bViewprofile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
				
			
		});
		bUpdateProfile=new JButton("Update profile");
		bUpdateProfile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		bApplyJob=new JButton("Apply Job");
		bApplyJob.addActionListener(new ActionListener() {
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
		
		this.setTitle("EMP Home Screen");
		this.setVisible(true);
		this.setBounds(10,10,500,1600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	public void setLayoutManager() {
		container.setLayout(null);
	}
	public void setLocationAndSize() {
		lTitle.setBounds(50, 80, 300, 30);
		bViewprofile.setBounds(50,150,300,30);
		bUpdateProfile.setBounds(50,200,300,30);
		bUpdateSkill.setBounds(50,250,300,30);
		bApplyJob.setBounds(50,300,300,30);
		bLogout.setBounds(50,350,300,30);
		
		
	}
	public void addComponentsToContainer() {
		container.add(lTitle);
		container.add(bViewprofile);
		container.add(bUpdateProfile);
		container.add(bUpdateSkill);
		container.add(bApplyJob);
		container.add(bLogout);	
	}

}
