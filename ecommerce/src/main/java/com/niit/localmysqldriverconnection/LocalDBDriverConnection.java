package com.niit.localmysqldriverconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LocalDBDriverConnection {
	public Statement connectDriver(Connection con) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/niit_db?autoReconnect=true&useSSL=false",
				"root", "mysql");
		Statement st = con.createStatement();
		return st;
	}
}
