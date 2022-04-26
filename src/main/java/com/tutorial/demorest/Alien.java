package com.tutorial.demorest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Alien {
	
	private String name;
	private String lname;
	private String email;
	private int id;
	
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(int id) {
		// TODO Auto-generated method stub
		this.id =id;
	}
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	@Override
	public String toString() {
		return "Alien [name=" + name + ", lname=" + lname + ", email=" + email + ", id=" + id + "]";
	}
	
	


}
