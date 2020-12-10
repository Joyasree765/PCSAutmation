package controller;
import java.io.*;

import java.sql.*;
import java.util.List;

import dao.IJobDao;
import dao.ISkillDao;
import daolmpl.JobDaolmpl;
import daolmpl.SkillDaolmpl;
import model.Job;
import model.Skill;


public class SkillController {
	ISkillDao skDao=null;
	public SkillController() throws ClassNotFoundException,SQLException
	{
		skDao=new SkillDaolmpl();
	}
	
	public Skill addSkill(String s1,String s2)  
	{
		Skill sk=new Skill();
		
		sk.setskillName(s1);
		
		sk.setskillDescription(s2);
		String skill=s1;
		if(skill.equals("Presentation"))
		{
			sk.setActive("Deactive");
		}
		else
		{
			sk.setActive("Active");
		
		}
		skDao.addSkill(sk);
		return sk;
		
}
	public List<Skill> getAllSkills()
	{
		List<Skill> allSkillList=skDao.getAllSkills();
		for(Skill sk:allSkillList) {
			System.out.println(sk);
		}
		
			return allSkillList;
	}
		public Skill getSkillById(String SkillId )
		{
			int id;
			id=Integer.parseInt(SkillId);
			Skill sk=skDao.getSkillById(id);
				return sk;
		}
		public void updateSkill() {
			try {
				BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
				int id;
				System.out.println("Enter the SkillId whose record you want to update:");
				id=Integer.parseInt(reader.readLine());
				Skill sk=skDao.getSkillById(id);
				skDao.updateSkill(sk);
			}
			catch(IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
		public void deactivateSkill(int id) {
			
				/*BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
				int id;
				System.out.println("Enter the SkillId whose record you want to deactivate:");
				id=Integer.parseInt(reader.readLine());
				Skill sk=skDao.getSkillById(id);*/
				skDao.deactivateSkill(id);
			
		}
		public void activateSkill(int id) {
			skDao.activeSkill(id);
			
		}
		//ISkillDao sk=new SkillDaolmpl();
		//public List<Skill> getAllSkill(){
			//List<Skill> allJoblist=sk.getAllSkills();
			 //for(Skill esk:allSkilllist) {
					//System.out.println(esk);
	//}	
			// return  allSkilllist;
			
		//}
		public void deleteSkill() {
			try {
				BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
				int id;
				System.out.println("Enter the SkillId whose record you want to delete:");
				id=Integer.parseInt(reader.readLine());
				skDao.deleteSkill(id);
			}
			catch(IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
	
}
