package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class updateStudent {
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
				
				System.out.println("Nhap ID sinh vien muon thay doi thong tin: ");
				String idToUpdate = input.nextLine();

				System.out.println("Nhap ho va ten sinh vien moi: ");
				String newName = input.nextLine();
				System.out.println("Lop moi: ");
				String newClass = input.nextLine();
				System.out.println("Khoa moi: ");
				String newFaculty = input.nextLine();
				System.out.println("Nganh moi: ");
				String newMajor = input.nextLine();

				String sql = "UPDATE laptrinhungdungmang.sinhvien_uit SET sinhvien_uit_name = '" + newName + "', sinhvien_uit_Class = '" + newClass + "', sinhvien_uit_faculty = '" + newFaculty + "', sinhvien_uit_major = '" + newMajor + "' WHERE sinhvien_uit_id = '" + idToUpdate + "'";
				stm.executeUpdate(sql);

				
				System.out.println("Thay doi thanh cong!");
				stm.close();
				cnt.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Thay doi that bai! Hay thu lai");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
