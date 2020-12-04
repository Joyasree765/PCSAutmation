package controller;
import java.io.*;

import java.sql.*;
import java.util.List;

import dao.IJobDao;
import daolmpl.JobDaolmpl;
import model.Job;

public class JobController {
	IJobDao jbDao=null;
	public  JobController() throws ClassNotFoundException, SQLException{
		jbDao=new JobDaolmpl();
	}
	public Job checkLogin(String JobId,String password) {
		Job jb=jbDao.checkLogin(JobId, password);
		return jb;
	}
	public void addJob() {
		Job jb=new Job();
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter JobTitle:");
			jb.setJobTitle(reader.readLine());
			System.out.println("Enter JobDescription:");
			jb.setJobDescription(reader.readLine());
			System.out.println("Enter companyName:");
			jb.setcompanyName(reader.readLine());
			System.out.println("Enter Location:");
			jb.setLocation(reader.readLine());
			System.out.println("Enter keySkill:");
			String keySkill=reader.readLine();
			jb.setkeySkill(keySkill);
			System.out.println("Enter Salary:");
			jb.setsalary(reader.readLine());
			if(keySkill.equals("COMMUNICATION")) {
				jb.setActive("Active");
			}
			else {
				jb.setActive("Deactive");
			}
			//Calling dao method for insert record
			jbDao.addJob(jb);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void getAllJobs() {
		
		List<Job> allJobList=jbDao.getAllJobs();
		for(Job job:allJobList) {
			System.out.println(job);
		}
	}
	public void getJobById() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter JobId whose record you want to access:");
			id=Integer.parseInt(reader.readLine());
			Job job=jbDao.getJobById(id);
			System.out.println(job);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void updateJob() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			String companyName, confirmcompanyName;
			System.out.println("Enter JobId whose record you want to update:");
			id=Integer.parseInt(reader.readLine());
			Job jb=jbDao.getJobById(id);
			System.out.println("Enter your new companyName:");
			companyName=reader.readLine();
			System.out.println("Re-enter same companyName to confirm:");
			confirmcompanyName=reader.readLine();
			if(companyName.equals(confirmcompanyName)) {
				jb.setcompanyName(companyName);
				jbDao.updateJob(jb);
			}
			else {
				System.out.println("Sorry! you have entered different companyName!");
			}
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void deactiveJob() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter JobId whose record you want to deactivate:");
			id=Integer.parseInt(reader.readLine());
			Job jb=jbDao.getJobById(id);
			jbDao.deactivateJob(jb);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void deleteJob() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter JobId whose record you want to delete:");
			id=Integer.parseInt(reader.readLine());
			jbDao.deleteJob(id);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}



}
