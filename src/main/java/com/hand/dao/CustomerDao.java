package com.hand.dao;


import java.sql.SQLException;
import java.util.List;

import com.hand.entity.Customer;


public interface CustomerDao {
	
	
	public List<Customer> query()throws SQLException;

	public List<Customer> query(String search);
	public List<Customer> queryById(Integer customer_id);
	public List<Customer> query(long page,long line);
	public void delete(int id);
	public long count();
	public void save(Customer customer);

	public void add(Customer customer);
}
