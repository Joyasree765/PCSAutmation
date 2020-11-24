package daolmpl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import config.JDBCConnection;
import dao.IJobDao;
import model.Job;

public class JobDaolmpl implements IJobDao {
	Connection conn=null;
	public JobDaolmpl() throws ClassNotFoundException, SQLException{
		//Opened connection
		conn=JDBCConnection.getDBConnection();
	}

	@Override
	public List<Job> getAllJobs() {
		List<Job> allJobList=new ArrayList<Job>();
		try{
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from Job");
			if(rst!=null) {
				Job jb=null;
				while(rst.next()) {
					jb=new Job();
					jb.setJobId(rst.getInt(1));
					jb.setJobTitle(rst.getString(2));
					jb.setJobDescription(rst.getString(3));
					jb.setcompanyName(rst.getString(4));
					jb.setLocation(rst.getString(5));
					jb.setkeySkill(rst.getString(6));
					jb.setsalary(rst.getString(7));
					jb.setActive(rst.getString(8));
					allJobList.add(jb); 
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return allJobList;
	}

	@Override
	public void addJob(Job jb) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("insert into Job(JobTitle,JobDescription,companyName,Location,keySkill,salary,Active) values(?,?,?,?,?,?,?)");
			pst.setString(1, jb.getJobTitle());
			pst.setString(2, jb.getJobDescription());
			pst.setString(3, jb.getcompanyName());
			pst.setString(4, jb.getLocation());
			pst.setString(5, jb.getkeySkill());
			pst.setString(6, jb.getsalary());
			pst.setString(7, jb.getActive());
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("1 record inserted...");
			}
			else {
				System.out.println("insertion failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		
	}

	@Override
	public Job getJobById(int id) {
		Job jb=new Job();
		try{
			PreparedStatement pst=conn.prepareStatement("select * from Job where jbId=?");
			pst.setInt(1, id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null) {
				if(rst.next()) {
					jb.setJobId(rst.getInt(1));
					jb.setJobTitle(rst.getString(2));
					jb.setJobDescription(rst.getString(3));
					jb.setcompanyName(rst.getString(4));
					jb.setLocation(rst.getString(5));
					jb.setkeySkill(rst.getString(6));
					jb.setsalary(rst.getString(7));
					jb.setActive(rst.getString(8));
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return jb;
	}

	@Override
	public void updateJob(Job jb) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update Job set companyName=? where JobId=?");
			pst.setString(1, jb.getcompanyName());
			pst.setInt(2,  jb.getJobId());
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("1 record updated...");
			}
			else {
				System.out.println("updation failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}	
		
	}

	@Override
	public void deactivateJob(Job jb) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update Job set Active=? where JobId=?");
			pst.setString(1, "Deactive");
			pst.setInt(2, jb.getJobId());
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("Job deactivated...");
			}
			else {
				System.out.println("updation failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}	
		
	}

	@Override
	public void deleteJob(int id) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("delete from Job where JobId=?");
			pst.setInt(1, id);
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("Job deleted...");
			}
			else {
				System.out.println("deletion failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}	
		
	}
	
}