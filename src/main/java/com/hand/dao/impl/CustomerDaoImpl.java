package com.hand.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hand.dao.CustomerDao;
import com.hand.entity.Customer;
import com.hand.rowmapper.CountRom;
import com.hand.rowmapper.CustomerRom;
import com.hand.util.JdbcUtils;


public class CustomerDaoImpl implements CustomerDao {
	
	/**
	 * 根据id查询用户信息
	 */
	public List<Customer> queryById(Integer customer_id)  {
		
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from customer where customer_id=?";
			List<Customer> customer = JdbcUtils.executeQuery(conn, sql, new Object[]{customer_id},new CustomerRom());
			return customer;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtils.close(conn);
		}
		return new ArrayList();
	}
	public List<Customer> query(long page, long line){
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from customer where 1=1";
			Object[] params = null; 
			if (page>0 && line>0){
				sql = sql+" limit ?,?";
				long start = (page-1)*line;
				params =new Object[] {start,line};
			}
			List<Customer> customer = JdbcUtils.executeQuery(conn, sql, params, new CustomerRom());
			return customer;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn);
		}
		return new ArrayList();
	}
	public List<Customer> query(String search)  {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from customer where customer_id like ?";
			Object[] params = {"%"+search+"%"}; 
			List<Customer> customer = JdbcUtils.executeQuery(conn, sql, params, new CustomerRom());
			return customer;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn);
		}
		return new ArrayList();
	
	}
	public long count()  {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select count(*) from customer";
			List<Object> list = JdbcUtils.executeQuery(conn, sql, null, new CountRom());
			if(null!=list && !list.isEmpty()){
				return (Long)list.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public List<Customer> query() {
		return query(-1,-1);
	}
	public void delete(int id) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "delete from customer where id=?";
			JdbcUtils.executeUpdate(conn, sql, new Object[]{id});//这个数组是存放问号的值
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn);
		}
		
	}
	public void save(Customer customer) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "update customer set first_name=?,last_name=?,email=?,last_update=? where id=?";
			Object[] params = {customer.getFirst_name(),customer.getLast_name(),customer.getEmail(),customer.getLast_update()};
			JdbcUtils.executeUpdate(conn, sql,params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn);
		}
		
	}
	public void add(Customer customer) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into customer(first_name,last_name,email) values (?,?,?)";
			Object[] params = {customer.getFirst_name(),customer.getLast_name(),customer.getEmail()};
			JdbcUtils.executeUpdate(conn,sql,params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn);
		}
		}
		
	}
	


