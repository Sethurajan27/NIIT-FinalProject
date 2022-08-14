package com.niit.service;

import java.util.ArrayList;

import com.niit.entity.ProductDetails;

public interface CartService {
	ArrayList<ProductDetails> getAllCart(String uname);

	String addToCart(String userName, ProductDetails details);

	ArrayList<ProductDetails> removeFromCart(String productName);
}
