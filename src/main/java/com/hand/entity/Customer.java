package com.hand.entity;

public class Customer extends IdEntity {
	private String first_name;
	private String last_name;
	private String email;
	private int customerid;
	private String last_update;
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	@Override
	public String toString() {
		return "Customer [first_name=" + first_name + ", last_name=" + last_name + ", email=" + email + ", customerid="
				+ customerid + ", last_update=" + last_update + "]";
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getLast_update() {
		return last_update;
	}
	public void setLast_update(String last_update) {
		this.last_update = last_update;
	}
	
	
	
	
}
