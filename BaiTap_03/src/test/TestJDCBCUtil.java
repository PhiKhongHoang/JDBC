package test;

import java.sql.Connection;

import database.JDBCUtil;

public class TestJDCBCUtil {
	public static void main(String[] args) {
		Connection conn = JDBCUtil.getConnection();
		System.out.println(conn);
		JDBCUtil.closeConnection(conn);
	} 
}
