package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Sach;

public class SachDao implements DAOInterface<Sach> {
	public static SachDao getInstance() {
		return new SachDao();
	}
	
	@Override
	public int insert(Sach t) {
		int ketQua = 0;
		try {
//		bước 1: tạo kết nối đến csdl
			Connection conn = JDBCUtil.getConnection();
			
//		bước 2: tạo ra đối tượng statement
			Statement st = conn.createStatement();
			
//		bước 3: thực thi câu lệnh sql
//			String sql = "insert into sach (id, tenSach, giaBan, namXuatBan) "
//					+ "values (" 
//						+ t.getId() + ", "
//						+ t.getTenSach() + ", "
//						+ t.getGiaBan() + ", "
//						+ t.getNamXuatBan()
//					+ ")";
			String sql = "insert into sach (tenSach, giaBan, namXuatBan) "
					+ "values ('" 
						+ t.getTenSach() + "', "
						+ t.getGiaBan() + ", "
						+ t.getNamXuatBan()
					+ ")";
						
			ketQua = st.executeUpdate(sql);
			
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
	public int update(Sach t) {
		int ketQua = 0;
		try {
//		bước 1: tạo kết nối đến csdl
			Connection conn = JDBCUtil.getConnection();
			
//		bước 2: tạo ra đối tượng statement
			Statement st = conn.createStatement();
			
//		bước 3: thực thi câu lệnh sql
			String sql = "update sach "
					+ "set "
						+ "tenSach = '" + t.getTenSach() + "'" 
						+ ", giaBan = " + t.getGiaBan() 
						+ ", namXuatBan = "+ t.getNamXuatBan()
					+ " where id = " + t.getId();
						
			ketQua = st.executeUpdate(sql);
			
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
	public int delete(Sach t) {
		int ketQua = 0;
		try {
//		bước 1: tạo kết nối đến csdl
			Connection conn = JDBCUtil.getConnection();
			
//		bước 2: tạo ra đối tượng statement
			Statement st = conn.createStatement();
			
//		bước 3: thực thi câu lệnh sql
			String sql = "delete from sach "
					+ " where id = " + t.getId();
						
			ketQua = st.executeUpdate(sql);
			
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
	public ArrayList<Sach> selectAll() {
		ArrayList<Sach> ketQua = new ArrayList<Sach>();
		try {
//		bước 1: tạo kết nối đến csdl
			Connection conn = JDBCUtil.getConnection();
			
//		bước 2: tạo ra đối tượng statement
			Statement st = conn.createStatement();
			
//		bước 3: thực thi câu lệnh sql
			String sql = "select * from sach ";
						
			ResultSet rs = st.executeQuery(sql);
			
//			bước 4: xử lý kết quả
			while(rs.next()) {
				int id = rs.getInt("id"); // có thể dùng tên or thứ tự (tt từ 1)
				String tenSach = rs.getString("tenSach");
				double giaBan = rs.getDouble(3);
				int namXuatBan = rs.getInt(4);
				Sach sach = new Sach(id, tenSach, giaBan, namXuatBan);
				ketQua.add(sach);
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
	public Sach selectById(Sach t) {
		Sach ketQua = null;
		try {
//		bước 1: tạo kết nối đến csdl
			Connection conn = JDBCUtil.getConnection();
			
//		bước 2: tạo ra đối tượng statement
			Statement st = conn.createStatement();
			
//		bước 3: thực thi câu lệnh sql
			String sql = "select * from sach where id = " + t.getId();
						
			ResultSet rs = st.executeQuery(sql);
			
//			bước 4: xử lý kết quả
			while(rs.next()) {
				int id = rs.getInt("id"); // có thể dùng tên or thứ tự (tt từ 1)
				String tenSach = rs.getString("tenSach");
				double giaBan = rs.getDouble(3);
				int namXuatBan = rs.getInt(4);
				ketQua = new Sach(id, tenSach, giaBan, namXuatBan);
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
	public ArrayList<Sach> selectByCondition(String condition) {
		ArrayList<Sach> ketQua = new ArrayList<Sach>();
		try {
//		bước 1: tạo kết nối đến csdl
			Connection conn = JDBCUtil.getConnection();
			
//		bước 2: tạo ra đối tượng statement
			Statement st = conn.createStatement();
			
//		bước 3: thực thi câu lệnh sql
			String sql = "select * from sach where " + condition;
						
			ResultSet rs = st.executeQuery(sql);
			
//			bước 4: xử lý kết quả
			while(rs.next()) {
				int id = rs.getInt("id"); // có thể dùng tên or thứ tự (tt từ 1)
				String tenSach = rs.getString("tenSach");
				double giaBan = rs.getDouble(3);
				int namXuatBan = rs.getInt(4);
				Sach sach = new Sach(id, tenSach, giaBan, namXuatBan);
				ketQua.add(sach);
			}
			
//			bước 5: ngắt kết nối
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return ketQua;
	}
	
}
