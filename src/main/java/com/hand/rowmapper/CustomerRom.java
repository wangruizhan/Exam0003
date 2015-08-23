package com.hand.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.entity.Customer;
import com.hand.util.RowMapper;



public class CustomerRom implements RowMapper{

	
	public Object getEntity(ResultSet rs) throws SQLException {
		Customer customer = new Customer();
		customer.setCustomerid(rs.getInt("customer_id"));
		customer.setFirst_name(rs.getString("first_name"));
		customer.setLast_name(rs.getString("last_name"));
		customer.setEmail(rs.getString("email"));
		customer.setLast_update(rs.getString("last_update"));
		
		return customer;
		
	}
	

}
