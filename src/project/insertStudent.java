package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class insertStudent {
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
				
				System.out.println("Nhap ID sinh vien muon them vao database: ");
				String id = input.nextLine();
	
				System.out.println("Nhap ho va ten sinh vien: ");
				String name = input.nextLine();
				System.out.println("Lop: ");
				String Class = input.nextLine();
				System.out.println("Khoa: ");
				String faculty = input.nextLine();
				System.out.println("Nganh: ");
				String major = input.nextLine();
		
				String sql = "INSERT INTO laptrinhungdungmang.sinhvien_uit VALUES ('" + id + "','" + name + "','" + Class + "','" + faculty + "','" + major + "')";

				stm.executeUpdate(sql);
				
				System.out.println("Them thanh cong!");
				stm.close();
				cnt.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Them that bai! Hay thu lai");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
