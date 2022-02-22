package com.ruhi.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {
	Connection conn;
	 Statement statement;
	ConnectionDB() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","123456");
		statement = conn.createStatement();
	}
	
	public int insert(String Data) throws SQLException {
		System.out.println("------> " + Data);
		int resultInt = statement.executeUpdate(Data);
		return resultInt;
	}
	
	public int update(String Data) throws SQLException {
		int resultInt = statement.executeUpdate(Data);
		return resultInt;
	}
	
	public int delete(String Data) throws SQLException {
		int resultInt = statement.executeUpdate(Data);
		return resultInt;
	}
	
	public void display() throws SQLException {
		ResultSet resultSet = statement.executeQuery("select * from ");
		while(resultSet.next()) {
			System.out.println(resultSet.getString(1));
		}
	}
	
	@Override
	protected void finalize() throws Throwable {
		conn.close();
	}
	
}