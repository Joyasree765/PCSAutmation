package daolmpl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import config.JDBCConnection;
import dao.ISkillDao;
import model.Skill;


public class SkillDaolmpl implements ISkillDao {
	Connection conn=null;
	public SkillDaolmpl() throws ClassNotFoundException, SQLException{
		//Opened connection
		conn=JDBCConnection.getDBConnection();
	}
	public Skill checkLogin(String SkillId, String password) {
		Skill sk=new Skill();
		try{
			PreparedStatement pst=conn.prepareStatement("select * from Skill where SkillId=? and password=?");
			pst.setString(1, SkillId);
			pst.setString(2, password);
			ResultSet rst=pst.executeQuery();
			if(rst!=null) {
				if(rst.next()) {
					sk.setskillId(rst.getInt(1));
					sk.setskillName(rst.getString(2));
					sk.setskillDescription(rst.getString(3));
					sk.setActive(rst.getString(8));
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return sk;
	}

	@Override
	public List<Skill> getAllSkills() {
		List<Skill> allSkillList=new ArrayList<Skill>();
		try{
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from Skill");
			if(rst!=null) {
				Skill sk=null;
				while(rst.next()) {
					sk=new Skill();
					sk.setskillId(rst.getInt(1));
					sk.setskillName(rst.getString(2));
					sk.setskillDescription(rst.getString(3));
					sk.setActive(rst.getString(4));
					allSkillList.add(sk); 
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return allSkillList;
	}

	@Override
	public void addSkill(Skill sk) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("insert into Skill(SkillName,SkillDescription,Active) values(?,?,?)");
			pst.setString(1, sk.getskillName());
			pst.setString(2, sk.getskillDescription());
			pst.setString(3, sk.getActive());
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
	public Skill getSkillById(int id) {
		Skill sk=new Skill();
		try{
			PreparedStatement pst=conn.prepareStatement("select * from Skill where SkillId=?");
			pst.setInt(1, id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null) {
				if(rst.next()) {
					sk.setskillId(rst.getInt(1));
					sk.setskillName(rst.getString(2));
					sk.setskillDescription(rst.getString(3));
					sk.setActive(rst.getString(4));
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return sk;
	}

	@Override
	public void updateSkill(Skill sk) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update Skill set SkillDescription=? where SkillId=?");
			pst.setString(1, sk.getskillDescription());
			pst.setInt(2, sk.getskillId());
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
	public void deactivateSkill(Skill sk) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update Skill set Active=? where SkillId=?");
			pst.setString(1, "Deactive");
			pst.setInt(2, sk.getskillId());
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("Skill deactivated...");
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
	public void deleteSkill(int id) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("delete from Skill where SkillId=?");
			pst.setInt(1, id);
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("Skill deleted...");
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
