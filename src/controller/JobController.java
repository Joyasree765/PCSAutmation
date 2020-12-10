package controller;
import java.io.*;

import java.sql.*;
import java.util.List;

import dao.IEmpJobDao;
import dao.IJobDao;
import daolmpl.EmpJobDaolmpl;
import daolmpl.JobDaolmpl;
import model.EmpJob;
import model.Job;

public class JobController {
	IJobDao jobDao=null;
	public JobController() throws ClassNotFoundException,SQLException
	{
		jobDao=new JobDaolmpl();
	}
	public void addJob(String s1,String s2,String s3,String s4,String s5,String s6)  {
	Job job=new Job();
	
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		//System.out.println("Enter Job Title :");
		String title=s1;
		job.setJobTitle(s1);
		//System.out.println("Enter Job Description:");
		job.setJobDescription(s2);
		//System.out.println("Enter Company Name :");
		job.setcompanyName(s3);
		//System.out.println("Enter Location:");
		job.setLocation(s4);
		//System.out.println("Enter KeySkill:");
		job.setkeySkill(s5);
		//System.out.println("Enter Salary:");
		job.setsalary(s6);
		if(title.equals("HR"))
		{
			job.setActive("Active");
		}
		else
		{
			job.setActive("Deactive");
		
		}
		jobDao.addJob(job);
	}
	
	public void getAllJob()
	{
		List<Job> allJobList=jobDao.getAllJob();
		for(Job job:allJobList)
		{
			System.out.println(job);
		}
		
	}
	public void getJobById()
	{
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter the JobId whose record you want to access:");
			id=Integer.parseInt(reader.readLine());
			Job job=jobDao.getJobById(id);
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
			System.out.println("Enter the JobId whose record you want to update:");
			id=Integer.parseInt(reader.readLine());
			Job job=jobDao.getJobById(id);
			jobDao.updateJob(job);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void deactivateJob(int id) {
		//try {
			//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			//int id;
			//System.out.println("Enter the JobId whose record you want to deactivate:");
			//id=Integer.parseInt(reader.readLine());
			Job job=jobDao.getJobById(id);
			jobDao.deactivateJob(job);
		//}
		//catch(IOException ex) {
			//System.out.println(ex.getMessage());
		//}
	}
	public void activateJob(int id) {
		jobDao.activeJob(id);
		
	}
	IJobDao job=new JobDaolmpl();
	public List<Job> getAllJobs(){
		List<Job> allJoblist=job.getAllJob();
		 for(Job ejb:allJoblist) {
				System.out.println(ejb);
}	
		 return  allJoblist;
		
	}
	public void deleteJob() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter the JobId whose record you want to delete:");
			id=Integer.parseInt(reader.readLine());
			jobDao.deleteJob(id);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
