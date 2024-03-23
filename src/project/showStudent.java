package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class showStudent {
	public static void main(String[] args) {
		String driverName = "com.mysql.cj.jdbc.Driver";
		String jdbcUrl = "jdbc:mysql://localhost:3306/laptrinhungdungmang?useSSL=false";
		String username = "huan";
		String password = "1234";
		
		try {
			Class.forName(driverName);
			
			try {
				Connection cnt = DriverManager.getConnection(jdbcUrl,username,password);
				
				Statement stm = cnt.createStatement();
				String sql = "SELECT * FROM laptrinhungdungmang.sinhvien_uit;" ;
				ResultSet result = stm.executeQuery(sql);
				
				while (result.next()) {
					String id = result.getString(1);
					String name = result.getString(2);
					String Class = result.getString(3);
					String faculty = result.getString(4);
					String major = result.getString(5);
					sinhvien_uit student = new sinhvien_uit(id, name, Class, faculty, major);
					System.out.println("" + student.toString());
					
				}
				stm.close();
				cnt.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
