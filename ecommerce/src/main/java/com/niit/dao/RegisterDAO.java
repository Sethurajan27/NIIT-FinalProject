package com.niit.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Service;

import com.niit.localmysqldriverconnection.LocalDBDriverConnection;

@Service
public class RegisterDAO {

	public String userRegistration(String name, String address, String contact, String email, String userName,
			String password) {

		Connection con = null;
		String result = null;
		try {
			LocalDBDriverConnection lc = new LocalDBDriverConnection();
			Statement st = lc.connectDriver(con);
			try {
				st.execute(
						"CREATE TABLE `user_details` (`Reg_ID` int NOT NULL AUTO_INCREMENT COMMENT 'Registration Id',`name` varchar(30) NOT NULL COMMENT 'Name',`address` varchar(150) NOT NULL COMMENT 'address',`Contact` varchar(10) NOT NULL COMMENT 'Contact',`Email` varchar(30) NOT NULL COMMENT 'Email Address',`userName` varchar(30) NOT NULL COMMENT 'username',`password` varchar(30) NOT NULL COMMENT 'Password',PRIMARY KEY (`Reg_ID`));");
			} catch (Exception e) {
				System.out.println(e);
			}
			ResultSet rs = st.executeQuery("select * from user_details;");
			while (rs.next()) {
				String contact1 = rs.getString("contact");
				String email1 = rs.getString("Email");
				String userName1 = rs.getString("userName");

				if (name.isEmpty() || address.isEmpty() || contact.isEmpty() || email.isEmpty() || userName.isEmpty()
						|| password.isEmpty()) {
					result = "Fields should not be empty!!!";
					break;
				} else if (contact1.equals(contact)) {
					result = "Contact already exist!!!";
					break;
				} else if (email1.equals(email)) {
					result = "Email already exist!!!";
					break;
				} else if (userName1.equals(userName)) {
					result = "User Name already exist!!!";
					break;
				}
			}
			if (result == null)
				st.executeUpdate("insert into user_details(Name, address,Contact,Email,userName,password) values('"
						+ name + "','" + address + "','" + contact + "','" + email + "','" + userName + "','" + password
						+ "')");

		} catch (

		Exception e) {
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
