package daolmpl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import config.JDBCConnection;
import dao.IEmpSkillDao;
import model.EmpSkill;

public class EmpSkillDaolmpl implements IEmpSkillDao {
	Connection conn=null;
	public EmpSkillDaolmpl() throws ClassNotFoundException, SQLException{
		//Opened connection
		conn=JDBCConnection.getDBConnection();
	}
	public EmpSkill checkLogin(String ESId, String password) {
		EmpSkill es=new EmpSkill();
		try{
			PreparedStatement pst=conn.prepareStatement("select * from EmpSkill where ESId=? and password=?");
			pst.setString(1, ESId);
			pst.setString(2, password);
			ResultSet rst=pst.executeQuery();
			if(rst!=null) {
				if(rst.next()) {
					es.setESId(rst.getInt(1));
					es.setEmployeeId(rst.getString(2));
					es.setSkillId(rst.getString(3));
					es.setExpYear(rst.getString(4));
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return es;
	}

	@Override
	public List<EmpSkill> getAllEmpSkills() {
		List<EmpSkill> allEmpSkillList=new ArrayList<EmpSkill>();
		try{
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from EmpSkill");
			if(rst!=null) {
				EmpSkill es=null;
				while(rst.next()) {
					es=new EmpSkill();
					es.setESId(rst.getInt(1));
					es.setEmployeeId(rst.getString(2));
					es.setSkillId(rst.getString(3));
					es.setExpYear(rst.getString(4));
					allEmpSkillList.add(es); 
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return allEmpSkillList;
	}

	@Override
	public void addEmpSkill(EmpSkill es) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("insert into EmpSkill(EmployeeId, SkillId,ExpYear) values(?,?,?)");
			pst.setString(1, es.getEmployeeId());
			pst.setString(2, es.getSkillId());
			pst.setString(3, es.getExpYear());
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
	public EmpSkill getEmpSkillById(int id) {
		EmpSkill es=new EmpSkill();
		try{
			PreparedStatement pst=conn.prepareStatement("select * from EmpSkill where esId=?");
			pst.setInt(1, id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null) {
				if(rst.next()) {
					es.setESId(rst.getInt(1));
					es.setEmployeeId(rst.getString(2));
					es.setSkillId(rst.getString(3));
					es.setExpYear(rst.getString(4));
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return es;
	}

	@Override
	public void updateEmpSkill(EmpSkill es) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update EmpSkill set EmployeeId=? where esId=?");
			pst.setString(1, es.getEmployeeId());
			pst.setInt(2, es.getESId());
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
	public void deactivateEmpSkill(EmpSkill es) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update EmpSkill set ExpYear=? where ESId=?");
			pst.setString(1, "Deactive");
			pst.setInt(2, es.getESId());
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("EmpSkill deactivated...");
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
	public void deleteEmpskill(int id) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("delete from EmpSkill where ESId=?");
			pst.setInt(1, id);
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("EmpSkill deleted...");
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
