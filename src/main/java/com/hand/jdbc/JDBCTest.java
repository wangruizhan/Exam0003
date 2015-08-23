package com.hand.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class JDBCTest {
	
//	public static Connection getConnection(){
//		Connection conn = null;
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_db","root","123456");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return conn;
//	}
//	public static void insert(){
//		Connection conn = getConnection();
//		try {
//			String sql = "insert into tbl_user(name,password,email)"+
//						"values('Tom','123456','tom@gmail.com')";
//			Statement st = conn.createStatement();
//			int count = st.executeUpdate(sql);
//			System.out.println("向用户表中插入"+count+"条记录");
//			conn.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	public static void update(){
//		Connection conn = getConnection();
//		try {
//			String sql = "UPDATE tbl_user SET email = 'tom@126.com' where name='Tom'";
//			Statement st = conn.createStatement();
//			int count = st.executeUpdate(sql);
//			System.out.println("向用户表中更新"+count+"条记录");
//			conn.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	public static void delete(){
//		Connection conn = getConnection();
//		try {
//			String sql = "delete from tbl_user where name='Tom'";
//			Statement st = conn.createStatement();
//			int count = st.executeUpdate(sql);
//			System.out.println("从用户表中删除了"+count+"条记录");
//			conn.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	public static void main(String[] args) {
		//delete();
		//update();
		//insert();
		String sql = "select * from customer";
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","123456");
			
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getInt("customer_id")+" ");
				System.out.println(rs.getString("first_name")+" ");
				System.out.println(rs.getString("last_name")+" ");
				System.out.println(rs.getString("email")+" ");
				System.out.println();
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (Exception e2) {
				
			}
			try {
				st.close();
			} catch (Exception e2) {
				
			}
			try {
				conn.close();
			} catch (Exception e2) {
				
			}
		}
		
		
		
	}

}
