package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class deleteStudent {
	public static void main(String[] args) {
		String driverName = "com.mysql.cj.jdbc.Driver";
		String jdbcUrl = "jdbc:mysql://localhost:3306/laptrinhungdungmang?useSSL=false";
		String username = "huan";
		String password = "1234";
		Scanner input = new Scanner (System.in);
		
		
		try {
			Class.forName(driverName);
			
			try {
				Connection cnt = DriverManager.getConnection(jdbcUrl,username,password);
				Statement stm = cnt.createStatement();
				
				System.out.println("Nhap ho va ten sinh vien muon xoa khoi database: ");
				String nameToDelete = input.nextLine();

				String sql = "DELETE FROM laptrinhungdungmang.sinhvien_uit WHERE sinhvien_uit_name = '" + nameToDelete + "'";
		
				stm.executeUpdate(sql);
				
				System.out.println("Xoa thanh cong!");
				stm.close();
				cnt.close();
			
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Xoa that bai! Hay thu lai");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
