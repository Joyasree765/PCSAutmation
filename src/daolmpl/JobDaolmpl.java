package daolmpl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import config.JDBCConnection;
import dao.IJobDao;
import model.Job;

public class JobDaolmpl implements IJobDao {
	Connection conn=null;
	public JobDaolmpl() throws ClassNotFoundException,SQLException
	{
		conn=JDBCConnection.getDBConnection();
	}

	@Override
	public List<Job> getAllJob() {
		List<Job>allJobList =new ArrayList<Job>();
		try
		{
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("Select * from Job");
			if(rst!=null)
			{
				Job job=null;
				while(rst.next())
				{job=new Job();
					job.setJobId(rst.getInt(1));
					job.setJobTitle(rst.getString(2));
					job.setJobDescription(rst.getString(3));
					job.setcompanyName(rst.getString(4));
					job.setLocation(rst.getString(5));
					job.setkeySkill(rst.getString(6));
					job.setsalary(rst.getString(7));
					job.setActive(rst.getString(8));
					allJobList.add(job);
				}
			}
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return allJobList;	
	}

	@Override
	public void addJob(Job job) {
		try {
			PreparedStatement pst=conn.prepareStatement("Insert into Job(JobTitle,JobDescription,CompanyName,Location,KeySkill,Salary,Active) values(?,?,?,?,?,?,?)");
			pst.setString(1,job.getJobTitle());
			pst.setString(2,job.getJobDescription());
			pst.setString(3,job.getcompanyName());
			pst.setString(4,job.getLocation());
			pst.setString(5,job.getkeySkill());
			pst.setString(6,job.getsalary());
			pst.setString(7,job.getActive());
			int i=pst.executeUpdate();
			
			if(i==1)
			{
				System.out.println("1 record inserted");
			}
			else
			{
				System.out.println("Insertion failed...");
			}
		}
			catch(SQLException ex)
			{
				System.out.println(ex.getMessage());
			}
		
	}

	@Override
	public Job getJobById(int id) {
		Job job=new Job();
		try
		{
			PreparedStatement pst=conn.prepareStatement("Select * from Job where JobId=?");
			pst.setInt(1, id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null)
			{
				if(rst.next())
				{
					job.setJobId(rst.getInt(1));
					job.setJobTitle(rst.getString(2));
					job.setJobDescription(rst.getString(3));
					job.setcompanyName(rst.getString(4));
					job.setLocation(rst.getString(5));
					job.setkeySkill(rst.getString(6));
					job.setsalary(rst.getString(7));
					job.setActive(rst.getString(8));
				}
			}
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}	
		return job;
	}

	@Override
	public void updateJob(Job job) {
		try {
			PreparedStatement pst=conn.prepareStatement("update Job set Salary=? where JobId=?");
			pst.setString(1, job.getsalary());
			pst.setInt(2, job.getJobId());
			int i=pst.executeUpdate();
			
			if(i==1)
			{
				System.out.println("1 record updated");
			}
			else
			{
				System.out.println("Updation failed...");
			}
		}
			catch(SQLException ex)
			{
				System.out.println(ex.getMessage());
			}
	}

	@Override
	public void deactivateJob(Job job) {
		try {
			PreparedStatement pst=conn.prepareStatement("Update Job set Active=? where JobId=?");
			pst.setString(1,"Deactive");
			pst.setInt(2,job.getJobId());
			int i=pst.executeUpdate();
			
			if(i==1)
			{
				System.out.println("Job Deactivated");
			}
			else
			{
				System.out.println("Updation failed...");
			}
		}
			catch(SQLException ex)
			{
				System.out.println(ex.getMessage());
			}
		
	}

	@Override
	public void deleteJob(int id) {
		try {
			PreparedStatement pst=conn.prepareStatement("Delete From Job where JobId=?");
			pst.setInt(1,id);
			int i=pst.executeUpdate();
			
			if(i==1)
			{
				System.out.println("Job Deleted");
			}
			else
			{
				System.out.println("Deletion failed...");
			}
		}
			catch(SQLException ex)
			{
				System.out.println(ex.getMessage());
			}
		
	}

	@Override
	public void activeJob(int id) {
		try {
			PreparedStatement pst=conn.prepareStatement("Update Job set Active=? where JobId=?");
			pst.setString(1,"Active");
			pst.setInt(2,Job.getJobId());
			int i=pst.executeUpdate();
			
			if(i==1)
			{
				System.out.println("Job Deactivated");
			}
			else
			{
				System.out.println("Updation failed...");
			}
		}
			catch(SQLException ex)
			{
				System.out.println(ex.getMessage());
			}
		
	}
		
		
	}

