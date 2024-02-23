package database;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.cj.jdbc.DatabaseMetaData;
import com.mysql.cj.jdbc.Driver;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection c = null;
		
		try {
//			đăng ký mysql driver với driverManager
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
//			các thông số
			String url = "jdbc:mySQL://localhost:3306/ontap";
			String username = "root";
			String password = "";
			
//			tạo kết nối
			c = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return c;
	}
	
	public static void closeConnection(Connection c) {
		try {
			if(c != null) {
				c.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
