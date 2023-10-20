package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DynamicUpdate {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
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
			System.out.println("Enter new name:");
            prepareStatement.setString(1, bufferedReader.readLine());
            System.out.println("Enter new city name:");
            prepareStatement.setString(2, bufferedReader.readLine());
            System.out.println("Enter new email id:");
            prepareStatement.setString(3, bufferedReader.readLine());
            System.out.println("Enter new phone number:");
            prepareStatement.setLong(4, Long.parseLong(bufferedReader.readLine()));
            System.out.println("Enter existing user id:");

            int cid=Integer.parseInt(bufferedReader.readLine());
            prepareStatement.setInt(5, cid);
                        
			
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
