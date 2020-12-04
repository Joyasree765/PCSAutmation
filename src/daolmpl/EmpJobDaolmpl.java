package daolmpl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import config.JDBCConnection;
import dao.IEmpJobDao;
import model.EmpJob;


public class EmpJobDaolmpl implements IEmpJobDao {
	Connection conn=null;
	public EmpJobDaolmpl() throws ClassNotFoundException, SQLException{
		//Opened connection
		conn=JDBCConnection.getDBConnection();
	}
	public EmpJob checkLogin(String EJId, String password) {
		EmpJob ej=new EmpJob();
		try{
			PreparedStatement pst=conn.prepareStatement("select * from EmpJob where EJId=? and password=?");
			pst.setString(1, EJId);
			pst.setString(2, password);
			ResultSet rst=pst.executeQuery();
			if(rst!=null) {
				if(rst.next()) {
					ej.setEJId(rst.getInt(1));
					ej.setEmployeeId(rst.getString(2));
					ej.setJobId(rst.getString(3));
					ej.setRecruited(rst.getString(4));
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return ej;
	}

	@Override
	public List<EmpJob> getAllEmpJobs() {
		List<EmpJob> allEmpJobList=new ArrayList<EmpJob>();
		try{
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from EmpJob");
			if(rst!=null) {
				EmpJob ej=null;
				while(rst.next()) {
					ej=new EmpJob();
					ej.setEJId(rst.getInt(1));
					ej.setEmployeeId(rst.getString(2));
					ej.setJobId(rst.getString(3));
					ej.setRecruited(rst.getString(4));
					allEmpJobList.add(ej); 
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return allEmpJobList;
	}

	@Override
	public void addEmpJob(EmpJob ej) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("insert into EmpJob(EmployeeId, JobId,Recruited) values(?,?,?)");
			pst.setString(1, ej.getEmployeeId());
			pst.setString(2, ej.getJobId());
			pst.setString(3, ej.getRecruited());
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
	public EmpJob getEmpJobById(int id) {
		EmpJob ej=new EmpJob();
		try{
			PreparedStatement pst=conn.prepareStatement("select * from EmpJob where ejId=?");
			pst.setInt(1, id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null) {
				if(rst.next()) {
					ej.setEJId(rst.getInt(1));
					ej.setEmployeeId(rst.getString(2));
					ej.setJobId(rst.getString(3));
					ej.setRecruited(rst.getString(4));
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return ej;
	}

	@Override
	public void updateEmpJob(EmpJob ej) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update EmpJob set EmployeeId=? where EJId=?");
			pst.setString(1, ej.getEmployeeId());
			pst.setInt(2, ej.getEJId());
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
	public void deactivateEmpJob(EmpJob ej) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update EmpJob set Recruited=? where EJId=?");
			pst.setString(1, "Deactive");
			pst.setInt(2, ej.getEJId());
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("EmpJob deactivated...");
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
	public void deleteEmpJob(int id) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("delete from EmpJob where EJId=?");
			pst.setInt(1, id);
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("EmpJob deleted...");
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
