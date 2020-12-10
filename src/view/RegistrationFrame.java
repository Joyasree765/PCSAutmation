package view;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import controller.EmploeeController;
import model.Employee;


public class RegistrationFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	Container container;
	JFrame f;
	JLabel   lFirstName,lLastname,lUserId, lPassword,lconfirmPassword,lGender,lRole;
	JTextField tFirstName,tLastName,tUserId,tGender,tRole;
	JPasswordField tPassword,tconfirmPassword;
	JButton bsubmit;
	JCheckBox cTerms;
	EmploeeController empController=null;
	public RegistrationFrame() throws ClassNotFoundException, SQLException {
		container=getContentPane();
		f=new JFrame();
		lFirstName=new JLabel("First Name");
		lLastname=new JLabel("Last Name");
		lUserId=new JLabel("User Id");
		lPassword=new JLabel("Password");
		lconfirmPassword=new JLabel("confirm password");
		lGender=new JLabel("Gender");
		lRole=new JLabel("Role");
		
		tFirstName=new JTextField();
		tLastName=new JTextField();
		tUserId=new JTextField();
		tPassword=new JPasswordField();
		tconfirmPassword=new JPasswordField();
		tGender=new JTextField();
		tRole=new JTextField();
		bsubmit=new JButton("SUBMIT");
		empController=new EmploeeController();
		//Event handling for Login button
		bsubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
                 String s1,s2,s3,s4,s5,s6,s7;
				
				s1=tFirstName.getText();
				s2=tLastName.getText();
				s3=tUserId.getText();
				s4=new String(tPassword.getPassword());
				s5=tGender.getText();
				s6=tRole.getText();
				s7=new String(tconfirmPassword.getPassword());
				if(s4.equals(s7))
				{
					empController.addEmployee(s1,s2,s3,s4,s5,s6);
				}
				else
				{
					JOptionPane.showMessageDialog(f,"Oops! Password do not match,Retry!");
				}
				
			}
			
		});
		//cTerms=new JCheckBox("I agree to & condition");
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("Login Form");
		this.setVisible(true);
		this.setBounds(10,10,500,1600);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	public void setLayoutManager() {
		container.setLayout(null);
	}
	public void setLocationAndSize() {
		lFirstName.setBounds(30, 150, 100, 30);
		lLastname.setBounds(30, 200, 100, 30);
		lUserId.setBounds(30, 250, 100, 30);
		lPassword.setBounds(30, 300, 100, 30);
		lconfirmPassword.setBounds(30, 350, 100, 30);
		lGender.setBounds(30, 400, 100, 30);
		lRole.setBounds(30, 450, 100, 30);
		
		tFirstName.setBounds(250, 100, 150, 30);
		tLastName.setBounds(250, 150, 150, 30);
		tUserId.setBounds(250, 200, 150, 30);
		tPassword.setBounds(250, 250, 150, 30);
		tconfirmPassword.setBounds(250, 300, 150, 30);
		tGender.setBounds(250, 350, 150, 30);
		tRole.setBounds(250, 400, 150, 30);
		//cTerms.setBounds(150,450,250,30);
		
		
		bsubmit.setBounds(100,500,150,30);

	}
	public void addComponentsToContainer() {
		container.add(lFirstName);
		container.add(tFirstName);
		container.add(lLastname);
		container.add(tLastName);	
		container.add(lUserId);
		container.add(tUserId);
		container.add(lPassword);
		container.add(tPassword);
		container.add(lconfirmPassword);
		container.add(tconfirmPassword);
		container.add(lGender);
		container.add(tGender);
		container.add(lRole);
		container.add(tRole);
		//container.add(cTerms);
		container.add(bsubmit);
		
		
	}

}
