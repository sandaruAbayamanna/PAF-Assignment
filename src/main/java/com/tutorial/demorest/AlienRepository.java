package com.tutorial.demorest;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class AlienRepository {
	 
	Connection con = null;
	
	public AlienRepository() {
		String url ="jdbc:mysql://localhost:3306/ElectroGrid";
		String username="root";
		String password="root";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			
		}catch(Exception e) {
			System.out.println(e); 
		}
	}
	
	
	//get all values from DB
	public List<Alien> getAliens(){
		List<Alien> aliens = new ArrayList<>();
		String sql = "select * from user";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Alien a= new Alien();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setLname(rs.getString(3));
				a.setEmail(rs.getString(4));
				
				aliens.add(a); 
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		return aliens;
	}
	
	
	//get a single value as output from DB
	public Alien getAlien(int id) {
		
	String sql = "select * from user where id="+id;
	Alien a = new Alien();
	
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				
				
				
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setLname(rs.getString(3));
				a.setEmail(rs.getString(4));
				
				
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return a;
		
		}

	//inserting to DB
	public void create(Alien a1) {
		// TODO Auto-generated method stub
		
		String sql = "insert into user values(?,?,?,?)";
		

		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, a1.getId());
			st.setString(2,a1.getName());
			st.setString(3, a1.getLname());
			st.setString(4, a1.getEmail());
			st.executeUpdate();
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	//update
	
	public void update(Alien a1) {
		// TODO Auto-generated method stub
		
		String sql = "update user set name=?,lname=?,email=? where id=?";
		

		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1,a1.getName());
			st.setString(2, a1.getLname());
			st.setString(3, a1.getEmail());
			st.setInt(4, a1.getId());
			
			st.executeUpdate();
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void delete(int id) {
		String sql = "delete from user where id=?";
		

		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, id);
			st.executeUpdate();
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}

	}
}


