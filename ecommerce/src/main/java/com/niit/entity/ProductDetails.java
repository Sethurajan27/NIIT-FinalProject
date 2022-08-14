package com.niit.entity;

import org.springframework.stereotype.Component;

@Component
public class ProductDetails {
	private String productName;
	private String productType;
	private float productPrice;
	private String productSeller;
	public ProductDetails(String productName, String productType, float productPrice, String productSeller) {
		super();
		this.productName = productName;
		this.productType = productType;
		this.productPrice = productPrice;
		this.productSeller = productSeller;
	}
	public ProductDetails() {
		super();
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductSeller() {
		return productSeller;
	}
	public void setProductSeller(String productSeller) {
		this.productSeller = productSeller;
	}
}
