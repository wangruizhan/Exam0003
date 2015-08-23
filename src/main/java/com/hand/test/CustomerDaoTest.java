package com.hand.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hand.dao.CustomerDao;
import com.hand.dao.impl.CustomerDaoImpl;
import com.hand.entity.Customer;
import com.hand.util.ConnectionFactory;

public class CustomerDaoTest {

	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			
			conn= ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			
			
			CustomerDao customerDao = new CustomerDaoImpl();
			Customer tom = new Customer();
			List<Customer> list = new ArrayList<Customer>();
			list = customerDao.queryById(1);
			System.out.println(list);
			
//			tom.setFirst_name("abeec");;
//		
//			tom.setLast_name("edf");
//			tom.setEmail("tom@gmail.com");
//			
//			
//		
//			customerDao.save(conn, tom);
			
			//System.out.println(tom);
			
			
		
			
			//userDao.save(conn, tom);
//			tom.setName("tomcat");
//			tom.setPassword("234566");
//			tom.setEmail("tomcat@gmail.com");
			
			
//			customerDao.update(conn, 1L, tom);
//			tom.setId(1L);
//			customerDao.delete(conn, tom);
		
			
			conn.commit();
			
		} catch (Exception e) {
			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		}

	}

}
