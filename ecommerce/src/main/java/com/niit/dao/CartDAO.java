package com.niit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.entity.ProductDetails;
import com.niit.localmysqldriverconnection.LocalDBDriverConnection;

@Service
public class CartDAO {

	@Autowired
	ProductDetails details;
	
	public String addToCart(String userName, ProductDetails productDetails) {
		Connection con = null;
		String result = "Item Added to Cart!!!";
		try {
			LocalDBDriverConnection lc = new LocalDBDriverConnection();
			Statement st=lc.connectDriver(con);
			try {
				st.execute(
						"CREATE TABLE `Cart_details` (`CartId` int NOT NULL AUTO_INCREMENT COMMENT 'CartId',`userName` varchar(30) NOT NULL COMMENT 'username',`productName` varchar(20) NOT NULL COMMENT 'productName',`productType` varchar(20) NOT NULL COMMENT 'productType',`productPrice` decimal(10,2) NOT NULL COMMENT 'productPrice',`productSeller` varchar(30) NOT NULL COMMENT 'productSeller',PRIMARY KEY (`CartId`));");
			} catch (Exception e) {
				System.out.println("try try catch");
				System.out.println(e);
			}
			ResultSet rs = st.executeQuery("select * from Cart_details;");
			while (rs.next()) {
				String userName1 = rs.getString("userName");
				String productName1 = rs.getString("productName");

				if (userName1.equals(userName) && productName1.equals(productDetails.getProductName())) {
					result = "Item added to cart Already!!!";
					break;
				}
			}
			if (result.equals("Item Added to Cart!!!"))
				st.executeUpdate(
						"insert into Cart_details(userName, productName, productType,productPrice,productSeller) values('"
								+ userName + "','" + productDetails.getProductName() + "','"
								+ productDetails.getProductType() + "','" + productDetails.getProductPrice() + "','"
								+ productDetails.getProductSeller() + "')");
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

	public ArrayList<ProductDetails> getAllCart(String userName) {
		Connection con = null;
		ArrayList<ProductDetails> arrayList = new ArrayList<ProductDetails>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/niit_db?autoReconnect=true&useSSL=false",
					"root", "mysql");
			Statement st = con.createStatement();
			try {
				st.execute(
						"CREATE TABLE `Cart_details` (`CartId` int NOT NULL AUTO_INCREMENT COMMENT 'CartId',`userName` varchar(30) NOT NULL COMMENT 'username',`productName` varchar(20) NOT NULL COMMENT 'productName',`productType` varchar(20) NOT NULL COMMENT 'productType',`productPrice` decimal(10,2) NOT NULL COMMENT 'productPrice',`productSeller` varchar(30) NOT NULL COMMENT 'productSeller',PRIMARY KEY (`CartId`));");
			} catch (Exception e) {
				System.out.println(e);
			}
			ResultSet rs = st.executeQuery("select * from Cart_details where userName = '" + userName + "';");
			while (rs.next()) {
				ProductDetails productDetails = new ProductDetails(rs.getString("productName"),
						rs.getString("productType"), Float.parseFloat(rs.getString("productPrice")),
						rs.getString("productSeller"));
				arrayList.add(productDetails);

			}
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
		return arrayList;
	}
	public ArrayList<ProductDetails> removeFromCart(String productName) {
		Connection con = null;
		ArrayList<ProductDetails> arrayList = new ArrayList<ProductDetails>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/niit_db?autoReconnect=true&useSSL=false",
					"root", "mysql");
			Statement st = con.createStatement();
			try {
				st.execute(
						"CREATE TABLE `Cart_details` (`CartId` int NOT NULL AUTO_INCREMENT COMMENT 'CartId',`userName` varchar(30) NOT NULL COMMENT 'username',`productName` varchar(20) NOT NULL COMMENT 'productName',`productType` varchar(20) NOT NULL COMMENT 'productType',`productPrice` decimal(10,2) NOT NULL COMMENT 'productPrice',`productSeller` varchar(30) NOT NULL COMMENT 'productSeller',PRIMARY KEY (`CartId`));");
			} catch (Exception e) {
				System.out.println(e);
			}
			st.executeUpdate("delete from Cart_details where productName = '" + productName + "';");
			ResultSet rs = st.executeQuery("select * from Cart_details;");
			while (rs.next()) {
				ProductDetails productDetails = new ProductDetails(rs.getString("productName"),
						rs.getString("productType"), Float.parseFloat(rs.getString("productPrice")),
						rs.getString("productSeller"));
				arrayList.add(productDetails);
			}
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
		return arrayList;
	}
}
