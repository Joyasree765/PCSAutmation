package view;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import java.awt.Container;
import java.sql.*;
import javax.swing.*;
import config.JDBCConnection;

public class AllEmployeeFrame extends JFrame {
	JFrame frame;
	Container container;
	public void AllEmployeesFrame() throws ClassNotFoundException, SQLException {
		Connection conn=JDBCConnection.getDBConnection();
		Statement stmt=conn.createStatement();
		frame=new JFrame();   
		JTable table=new JTable();
		DefaultTableModel model = new DefaultTableModel(new String[]{"EmployeeId", "FirstName", "LastName", "Role","Gender", "Active"}, 0);
		ResultSet rst=stmt.executeQuery("select * from Employee");
		while(rst.next())
		{
		    int aa = rst.getInt("EmployeeId");
		    String bb = rst.getString("FirstName");
		    String cc = rst.getString("LastName");
		    String dd = rst.getString("Role");
		    String ee = rst.getString("Gender");
		    String ff = rst.getString("Active");
		    model.addRow(new Object[]{aa,bb,cc,dd,ee,ff});
		    table.setModel(model);
		    container=getContentPane();
		    setLayoutManger();
		    JScrollPane sp=new JScrollPane(table);    
		    container.add(sp);
		    container.add(table);
		    table.setBounds(10,10,800,900);
		    this.setVisible(true);
		    this.setBounds(10,10,800,900);
		    this.setTitle("Employee Table");
		}
	}
	private void setLayoutManger() {
		container.setLayout(null);
		
	}

}
