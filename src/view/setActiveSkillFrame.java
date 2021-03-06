package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;
import controller.SkillController;


public class setActiveSkillFrame extends JFrame {
	Container container;
	JFrame f;
	JLabel lSkillId;
	JTextField tSkillId;
	JButton bActivate;
	SkillController skiController=null;
	
	public void ActivateSkillFrame() throws ClassNotFoundException, SQLException{
		container=getContentPane();
		f=new JFrame();
		lSkillId=new JLabel("Enter Skill Id");
		tSkillId=new JTextField();
		bActivate=new JButton("Activate");
		skiController=new SkillController();
		
		bActivate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int s;
				s=Integer.parseInt(tSkillId.getText());
				skiController.activateSkill(s);
			}
			
		});
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("Activate Skill");
		this.setVisible(true);
		this.setBounds(10,10,500,600);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	

	private void setLayoutManager() {
		container.setLayout(null);
		
	}
	private void setLocationAndSize() {
		lSkillId.setBounds(30, 150, 300, 30);
		tSkillId.setBounds(200, 150, 150, 30);
		bActivate.setBounds(200, 250, 100, 30);
	}

	private void addComponentsToContainer() {
		container.add(lSkillId);
		container.add(tSkillId);
		container.add(bActivate);
	}


}
