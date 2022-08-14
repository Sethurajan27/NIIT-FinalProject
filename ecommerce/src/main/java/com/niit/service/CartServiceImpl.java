package com.niit.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.CartDAO;
import com.niit.entity.ProductDetails;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDAO cartDAO;

	public ArrayList<ProductDetails> getAllCart(String uname) {
		return cartDAO.getAllCart(uname);
	}

	public String addToCart(String userName, ProductDetails details) {
		return cartDAO.addToCart(userName,details);
	}

	public ArrayList<ProductDetails> removeFromCart(String productName) {
		return cartDAO.removeFromCart(productName);
	}

}
