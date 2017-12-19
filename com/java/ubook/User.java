package com.java.ubook;

/*
 * 用户信息类
 */

public class User {
	private Integer id;
	private String loginname;
	private String password;
	private String username;
	private String sex;
	private String address;
	private Integer age;
	private String phone;
	private String email;
	
	//构造器，
	public User() {
		super();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	//改写该类的toString()方法，便以调试
	@Override
	public String toString() {
		return "User[id="+id+",loginname="+ loginname + ", password=" + password + 
				", username=" + username + " ,sex=" + sex + 
				", address=" + address + ", age=" + age + "]";
	}
	

}
