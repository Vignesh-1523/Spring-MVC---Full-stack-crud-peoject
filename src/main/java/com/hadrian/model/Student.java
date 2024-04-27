package com.hadrian.model;

// For storing the input values from the register form and this will be used to send to the database.
// In the insertRegisteredRecord() method we can able to pass parameters. Here we have only 4 so we can pass.
// But what if more than 4 occurs for that instead passing directly like (String inpName, String inpEmail...)
// We make a HttpServlet request and get by that and store those values in a Bean class.
// We create a Bean class Student and then store those value here.
public class Student {
	private int id;
	private String name;
	private String email;
	private String password;
	private long mobile;
    
	public Student() {
		// constructor without parameters
		super();
	}
	// constructor with id
	public Student(int id, String name, String email, String password, long mobile) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}
    // constructor without id
	public Student(String name, String email, String password, long mobile) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
}
