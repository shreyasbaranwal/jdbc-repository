package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertOperation {

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
			
			PreparedStatement prepareStatement = connection.prepareStatement("insert into customer values(?,?,?,?,?)");
			prepareStatement.setInt(1, 53);
			prepareStatement.setString(2, "Lavya");
			prepareStatement.setString(3, "Mumbai");
			prepareStatement.setString(4, "lavya@gmail.com");
			prepareStatement.setLong(5,8425986125L);
			
			if(prepareStatement.executeUpdate()>0) {
				System.out.println("Record Inserted");
			}
			else
			{
				System.out.println("Record not inserted");
			}
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

	}

}
