package com.grocery.model;

public class UserRegister {

	int userid;
	String name;
	String password;
	String address;
	String mobile;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public UserRegister(int userid, String name, String password) {
		super();
		this.userid = userid;
		this.name = name;
		this.password = password;
	}
	
	public UserRegister() {
		super();
	}
	@Override
	public String toString() {
		return "UserRegistor [userid=" + userid + ", name=" + name + ", password=" + password + "]";
	}
	
	
}
