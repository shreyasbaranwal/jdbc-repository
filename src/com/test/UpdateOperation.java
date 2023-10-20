package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_first_db","root","root");
			if(connection!=null)
			{
				System.out.println("Connected Hurrah!!");
			}
			else
			{
				System.out.println("Not Connected @_@");
			}
			
			PreparedStatement prepareStatement = connection.prepareStatement("Update customer set cname =? , caddress = ?, email = ?,phone =? where cid =?");
			prepareStatement.setString(1,"Kiran");
			prepareStatement.setString(2,"Jaipur");
			prepareStatement.setString(3,"kiran@abc.com");
			prepareStatement.setLong(4,5845865892L);
			prepareStatement.setInt(5,5353);
			
			if(prepareStatement.executeUpdate()>0)
			{
				System.out.println("Record Updated!!!");
				prepareStatement = connection.prepareStatement("Select * from customer where cid =?");
				prepareStatement.setInt(1,5353);
				ResultSet resultSet = prepareStatement.executeQuery();
				while(resultSet.next()) {
					System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4)+" "+resultSet.getLong(5));
				}
				
			}
			else
			{
				System.out.println(" Problem in update operation");
			}
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}}

}
