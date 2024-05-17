package com.org.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.org.dto.User;

public class UserDao {

	public void saveUser(User user) {
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userManagement","root","Asit7327@");
				PreparedStatement ps = con.prepareStatement("insert into user values (?,?,?,?,?)");
				
				String name = user.getName();
				int age = user.getAge();
				String email = user.getEmail();
				String pasword = user.getPassword();
				long mobile = user.getMobile();
				
				ps.setString(1, name);
				ps.setInt(2, age);
				ps.setString(3, email);
				ps.setString(4, pasword);
				ps.setLong(5, mobile);
				
				
				ps.executeUpdate();
				
				con.close();

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		
	}
	public User fetchUserByEmailAndPassword(String email,String password) {
		

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanagement","root","Asit7327@");
			PreparedStatement ps = con.prepareStatement("select * from user where email=? and password=?");
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				User user = new User();
				String Email = user.getEmail();
				String pasword = user.getPassword();
			
				ps.setString(3, Email);
				ps.setString(4, pasword);
				
				return user;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}
	
	public User fetchUserById(int id)
	{

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanagement","root","Asit7327@");
			PreparedStatement ps = con.prepareStatement("select * from user where id=?");
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				User user = new User();
				int id1 = user.getId();
			
				ps.setInt(1, id);
				
				return user;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<User> fetchAllUser()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanagement","root","Asit7327@");
			PreparedStatement ps = con.prepareStatement("select * from user");
			
			ResultSet rs = ps.executeQuery();
			List<User> li = new ArrayList<User>();
			while(rs.next())
			{
				User user = new User();
				 user.setId(rs.getInt("id"));
		         user.setName(rs.getString("name"));
		         user.setAge(rs.getInt("age"));
		         user.setEmail(rs.getString("email"));
		         user.setPassword(rs.getString("password"));
		         user.setMobile(rs.getInt("mobile"));
		         
		         li.add(user);
			}
			return li;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
