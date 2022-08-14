package com.niit.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Service;

import com.niit.localmysqldriverconnection.LocalDBDriverConnection;

@Service
public class LoginDAO {

	public String Validate(String uname, String pass) {

		Connection con = null;
		String password = null;
		String result = null;
		try {
			LocalDBDriverConnection lc = new LocalDBDriverConnection();
			Statement st = lc.connectDriver(con);
			ResultSet rs = st.executeQuery("SELECT password FROM user_details WHERE userName='" + uname + "'");

			while (rs.next()) {
				password = rs.getString(1);
			}

			if (pass.equals(password))
				result = "Success";
			else
				result = "Fail";

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
