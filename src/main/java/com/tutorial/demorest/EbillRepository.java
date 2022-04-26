package com.tutorial.demorest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EbillRepository {
	 
	Connection con = null;
	
	public EbillRepository() {
		String url ="jdbc:mysql://localhost:3306/ebill";
		String username="root";
		String password="";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			
		}catch(Exception e) {
			System.out.println(e); 
		}
	}
	
	//get all values from DB
		public List<Ebill> getEbills(){
			List<Ebill> ebills = new ArrayList<>();
			String sql = "select * from ebill_structure";
			
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					Ebill a= new Ebill();
					a.setBillId(rs.getInt(1));
					a.setAmount(rs.getInt(2));
					a.setAccNo(rs.getString(3));
					a.setRefNo(rs.getString(4));
					a.setStartDate(rs.getString(5));
					a.setEndDate(rs.getString(6));
					
					ebills.add(a); 
				}
				
			}catch(Exception e) {
				System.out.println(e);
			}
			
			
			return ebills;
		}
		
		//get a single value as output from DB
		public Ebill getEbill(int id) {
			
		String sql = "select * from ebill_structure where id="+id;
		Ebill a = new Ebill();
		
			
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				if(rs.next()) {
					
					a.setBillId(rs.getInt(1));
					a.setAmount(rs.getInt(2));
					a.setAccNo(rs.getString(3));
					a.setRefNo(rs.getString(4));
					a.setStartDate(rs.getString(5));
					a.setEndDate(rs.getString(6));
					
				}
				
			}catch(Exception e) {
				System.out.println(e);
			}
			
			return a;
			
			}
		
		//inserting to DB
		public void create(Ebill a1) {
			// TODO Auto-generated method stub

			String sql = "insert into ebill_structure values(?,?,?,?,?,?)";
			

			try {
				PreparedStatement st = con.prepareStatement(sql);
				st.setInt(1,a1.getBillId());
				st.setInt(2, a1.getAmount());
				st.setString(3, a1.getAccNo());
				st.setString(4, a1.getRefNo());
				st.setString(5, a1.getStartDate());
				st.setString(6, a1.getEndDate());
				st.executeUpdate();
				
				
				
			}catch(Exception e) {
				System.out.println(e);
			}
			
		}

        //update	
		public void update(Ebill a1) {
			// TODO Auto-generated method stub
			
			String sql = "update ebill_structure set amount=?,accNo=?,refNo=?,startDate=?,endDate=? where billId=?";
			
			try {
				PreparedStatement st = con.prepareStatement(sql);
				
				st.setInt(1,a1.getBillId());
				st.setInt(2, a1.getAmount());
				st.setString(3, a1.getAccNo());
				st.setString(4, a1.getRefNo());
				st.setString(5, a1.getStartDate());
				st.setString(6, a1.getEndDate());
				st.executeUpdate();
				
				
				
			}catch(Exception e) {
				System.out.println(e);
			}
			
		}
		
	//delete
		public void delete(int id) {
			String sql = "delete from ebill_structure where id=?";
			

			try {
				PreparedStatement st = con.prepareStatement(sql);
				
				st.setInt(1, id);
				st.executeUpdate();
				
				
				
			}catch(Exception e) {
				System.out.println(e);
			}

		}



}
