package view;
import java.awt.Container;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import config.JDBCConnection;

public class AllJobsFrame extends JFrame{
	JFrame frame;
	Container container;
	public AllJobsFrame() throws ClassNotFoundException, SQLException {
		Connection conn=JDBCConnection.getDBConnection();
		Statement stmt=conn.createStatement();
		frame=new JFrame();   
		JTable table=new JTable();
		DefaultTableModel model = new DefaultTableModel(new String[]{"JobId","JobTitle", "JobDescription", "CompanyName", "Location","KeySkill","Salary","Activate"}, 0);
		ResultSet rst=stmt.executeQuery("select * from Job");
		while(rst.next())
		{
		    int aa = rst.getInt("JobId");
		    String bb = rst.getString("JobTitle");
		    String cc = rst.getString("JobDescription");
		    String dd = rst.getString("CompanyName");
		    String ee = rst.getString("Location");
		    String ff = rst.getString("KeySkill");
		    String gg = rst.getString("Salary");
		    String hh = rst.getString("Activate");
		    model.addRow(new Object[]{aa,bb,cc,dd,ee,ff,gg,hh});
		    table.setModel(model);
		    container=getContentPane();
		    container.setLayout(null);
		    JScrollPane sp=new JScrollPane(table);    
		    container.add(sp);
		    container.add(table);
		    table.setBounds(10,10,800,900);
		    this.setVisible(true);
		    this.setBounds(10,10,800,900);
		    this.setTitle("Job Table");
		}

	}
	

}
