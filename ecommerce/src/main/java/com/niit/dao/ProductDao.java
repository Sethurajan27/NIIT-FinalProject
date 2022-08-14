package com.niit.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.entity.ProductDetails;
import com.niit.localmysqldriverconnection.LocalDBDriverConnection;

@Service
public class ProductDao {
	@Autowired
	ProductDetails details;

	public ArrayList<ProductDetails> getAllProducts() {
		Connection con = null;
		ArrayList<ProductDetails> arrayList = new ArrayList<ProductDetails>();

		try {
			LocalDBDriverConnection lc = new LocalDBDriverConnection();
			Statement st = lc.connectDriver(con);
			try {
				st.execute(
						"CREATE TABLE `Product_details` (`productId` int NOT NULL AUTO_INCREMENT COMMENT 'productId',`productName` varchar(20) NOT NULL COMMENT 'productName',`productType` varchar(20) NOT NULL COMMENT 'productType',`productPrice` decimal(10,2) NOT NULL COMMENT 'productPrice',`productSeller` varchar(30) NOT NULL COMMENT 'productSeller',PRIMARY KEY (`productId`));");
				st.execute(
						"insert into `Product_details` (productName, productType,productPrice,productSeller) values('Samsung S22', 'Mobile', 109999.00, 'Samsung Inc');");
				st.execute(
						"insert into `Product_details` (productName, productType,productPrice,productSeller) values('iphone 13', 'Mobile', 69999.00, 'Apple Inc');");
				st.execute(
						"insert into `Product_details` (productName, productType,productPrice,productSeller) values('Realme 8 pro', 'Mobile', 22000.00, 'Realme Inc');");
				st.execute(
						"insert into `Product_details` (productName, productType,productPrice,productSeller) values('Nothing 8 pro', 'Mobile', 32999.00, 'Nothing Inc');");
				st.execute(
						"insert into `Product_details` (productName, productType,productPrice,productSeller) values('Hp Pavilion', 'Laptop', 70000.0, 'Hp Inc');");
				st.execute(
						"insert into `Product_details` (productName, productType,productPrice,productSeller) values('Asus Rog', 'Laptop', 69990.00, 'Asus Inc');");
				st.execute(
						"insert into `Product_details` (productName, productType,productPrice,productSeller) values('Acer', 'Laptop', 62000.00, 'Acer Inc');");
				st.execute(
						"insert into `Product_details` (productName, productType,productPrice,productSeller) values('Apple', 'Laptop', 129990.00, 'Apple Inc');");
			} catch (Exception e) {
				System.out.println(e);
			}
			ResultSet rs = st.executeQuery("select * from product_details;");
			while (rs.next()) {
				ProductDetails details = new ProductDetails(rs.getString(2), rs.getString(3),
						Float.parseFloat(rs.getString(4)), rs.getString(5));
				arrayList.add(details);
			}
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
		return arrayList;
	}
}
