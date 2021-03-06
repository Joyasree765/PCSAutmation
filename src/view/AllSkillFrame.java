package view;
import java.awt.Component;
import java.awt.Container;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import config.JDBCConnection;

public class AllSkillFrame  extends JFrame {
	JFrame frame;
	Container container;
	public void AllSkillsFrame() throws ClassNotFoundException, SQLException {
		Connection conn=JDBCConnection.getDBConnection();
		Statement stmt=conn.createStatement();
		frame=new JFrame();   
		JTable table=new JTable();
		DefaultTableModel model = new DefaultTableModel(new String[]{"SkillId", "SkillName", "SkillDescription", "Active"}, 0);
		ResultSet rst=stmt.executeQuery("select * from Skill");
		while(rst.next())
		{
		    int aa = rst.getInt("SkillId");
		    String bb = rst.getString("SkillName");
		    String cc = rst.getString("SkillDescription");
		    String dd = rst.getString("Active");
		    model.addRow(new Object[]{aa,bb,cc,dd});
		    table.setModel(model);
		    container=getContentPane();
		    container.setLayout(null);
		    JScrollPane sp=new JScrollPane(table);    
		    container.add(sp);
		    container.add(table);
		    table.setBounds(10,10,800,900);
		    this.setVisible(true);
		    this.setBounds(10,10,800,900);
		    this.setTitle("Skill Table");
		}

	}

}
