package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.User;

public class UserDao implements DAOInterface<User> {
	public static UserDao getInstance() {
		return new UserDao();
	}
	
	@Override
	public int insert(User t) {
		int ketQua = 0;
		try {
//		bước 1: tạo kết nối đến csdl
			Connection conn = JDBCUtil.getConnection();
			
//		bước 2: tạo ra đối tượng statement
			String sql = "insert into users (username, password, hoVaTen) "
					+ "values (?, ?, ?)";
			
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, t.getUsername());
			pst.setString(2, t.getPassword());
			pst.setString(3, t.getHoVaTen());
			
//		bước 3: thực thi câu lệnh sql
			ketQua = pst.executeUpdate();
			
//			bước 4: xử lý kết quả
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");
			
//			bước 5: ngắt kết nối
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return ketQua;
	}

	@Override
	public int update(User t) {
		int ketQua = 0;
		try {
//		bước 1: tạo kết nối đến csdl
			Connection conn = JDBCUtil.getConnection();
			
//		bước 2: tạo ra đối tượng statement
			String sql = "update users "
					+ "set "
						+ "password = ?"
						+ ", hoVaTen = ?" 
					+ "' where username = ?"; 
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, t.getPassword());
			pst.setString(2, t.getHoVaTen());
			pst.setString(3, t.getUsername());
			
//		bước 3: thực thi câu lệnh sql		
			ketQua = pst.executeUpdate();
			
//			bước 4: xử lý kết quả
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");
			
//			bước 5: ngắt kết nối
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return ketQua;
	}

	@Override
	public int delete(User t) {
		int ketQua = 0;
		try {
//		bước 1: tạo kết nối đến csdl
			Connection conn = JDBCUtil.getConnection();
			
//		bước 2: tạo ra đối tượng statement
			String sql = "delete from users "
					+ " where username = ?";
			
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1,  t.getUsername());
			
//		bước 3: thực thi câu lệnh sql		
			ketQua = pst.executeUpdate();
			
//			bước 4: xử lý kết quả
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");
			
//			bước 5: ngắt kết nối
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return ketQua;
	}

	@Override
	public ArrayList<User> selectAll() {
		ArrayList<User> ketQua = new ArrayList<User>();
		try {
//		bước 1: tạo kết nối đến csdl
			Connection conn = JDBCUtil.getConnection();
			
//		bước 2: tạo ra đối tượng statement
			String sql = "select * from users ";
			PreparedStatement pst = conn.prepareStatement(sql);
			
//		bước 3: thực thi câu lệnh sql	
			ResultSet rs = pst.executeQuery(sql);
			
//			bước 4: xử lý kết quả
			while(rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String hoVaTen = rs.getString("hoVaTen");
				User User = new User(username, password, hoVaTen);
				ketQua.add(User);
			}
			
//			bước 5: ngắt kết nối
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return ketQua;
	}

	@Override
	public User selectById(User t) {
		User ketQua = null;
		try {
//		bước 1: tạo kết nối đến csdl
			Connection conn = JDBCUtil.getConnection();
			
//		bước 2: tạo ra đối tượng statement
			String sql = "select * from users where username = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, t.getUsername());
			
//		bước 3: thực thi câu lệnh sql
			ResultSet rs = pst.executeQuery();
			System.out.println(sql);
			
//		bước 4: xử lý kết quả
			while(rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String hoVaTen = rs.getString("hoVaTen");
				ketQua = new User(username, password, hoVaTen);
			}
			
//			bước 5: ngắt kết nối
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return ketQua;
	}

	@Override
	public ArrayList<User> selectByCondition(String condition) {
		ArrayList<User> ketQua = new ArrayList<User>();
				
		return ketQua;
	}
	
}
