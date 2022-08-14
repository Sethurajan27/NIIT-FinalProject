package com.niit.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.niit.entity.ProductDetails;
import com.niit.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/getAllProducts")
	public ArrayList<ProductDetails> getAllProducts() {
		return productService.getAllProducts();
	}
}
