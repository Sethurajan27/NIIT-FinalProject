package com.niit.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.ProductDao;
import com.niit.entity.ProductDetails;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	public ArrayList<ProductDetails> getAllProducts() {
		return productDao.getAllProducts();
	}

}
