package controller;
import java.io.*;
import java.sql.*;
import java.util.List;

import dao.ISkillDao;
import daolmpl.SkillDaolmpl;
import model.Skill;


public class SkillController {
	ISkillDao skDao=null;
	public  SkillController() throws ClassNotFoundException, SQLException{
		skDao=new SkillDaolmpl();
	}
	public Skill checkLogin(String SkillId,String password) {
		Skill sk=skDao.checkLogin(SkillId, password);
		return sk;
	}
	
	public void addSkill() {
		Skill sk=new Skill();
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter SkillName:");
			String skillName=reader.readLine();
			sk.setskillName(skillName);
			System.out.println("Enter SkillDescription:");
			sk.setskillDescription(reader.readLine());
			if(skillName.equals("CUSTOMER SERVICE")) {
				sk.setActive("Active");
			}
			else {
				sk.setActive("Deactive");
			}
			//Calling dao method for insert record
			skDao.addSkill(sk);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void getAllSkills() {
		
		List<Skill> allSkillList=skDao.getAllSkills();
		for(Skill sk:allSkillList) {
			System.out.println(sk);
		}
	}
	public void getSkillById() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter SkillId whose record you want to access:");
			id=Integer.parseInt(reader.readLine());
			Skill sk=skDao.getSkillById(id);
			System.out.println(sk);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void updateSkill() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			String skillDescription, confirmskillDescription;
			System.out.println("Enter SkillId whose record you want to update:");
			id=Integer.parseInt(reader.readLine());
			Skill sk=skDao.getSkillById(id);
			System.out.println("Enter your new skillDescription:");
			confirmskillDescription=reader.readLine();
			System.out.println("Re-enter same skillDescription to confirm:");
			confirmskillDescription=reader.readLine();
			if(confirmskillDescription.equals(confirmskillDescription)) {
				sk.setskillDescription(confirmskillDescription);
				skDao.updateSkill(sk);
			}
			else {
				System.out.println("Sorry! you have entered different skillDescription!");
			}
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void deactiveSkill() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("EnterSkillId whose record you want to deactivate:");
			id=Integer.parseInt(reader.readLine());
			Skill sk=skDao.getSkillById(id);
			skDao.deactivateSkill(sk);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void deleteSkill() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter SkillId whose record you want to delete:");
			id=Integer.parseInt(reader.readLine());
			skDao.deleteSkill(id);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}



}
