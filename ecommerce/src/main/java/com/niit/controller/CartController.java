package com.niit.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.entity.LoginDetails;
import com.niit.entity.ProductDetails;
import com.niit.service.CartService;
import com.niit.service.ProductService;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;
	@Autowired
	private ProductDetails productDetails;
	@Autowired
	private ProductService productService;
	@Autowired
	private LoginDetails loginDetails;

	@RequestMapping("/addToCart")
	public ModelAndView addToCart(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		String result = null;
		
		productDetails.setProductName(req.getParameter("cartProdnm").toString());
		productDetails.setProductPrice(Float.parseFloat(req.getParameter("cartProdprs").toString()));
		productDetails.setProductSeller(req.getParameter("cartProdslr").toString());
		productDetails.setProductType(req.getParameter("cartProdtyp").toString());

		HttpSession session = req.getSession();
		session.setAttribute("cartProd", productDetails);

		result = cartService.addToCart(session.getAttribute("userName").toString(), productDetails);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("Home.jsp");
		mv.addObject("name", session.getAttribute("userName").toString());
		mv.addObject("products", productService.getAllProducts());
		mv.addObject("message", result);
		return mv;
	}
	@RequestMapping("/getAllCart")
	public ModelAndView getAllCart(HttpServletRequest req, HttpServletResponse res){
		
		ModelAndView mv = new ModelAndView();
		HttpSession session = req.getSession();
		ArrayList<ProductDetails> arrayList = cartService.getAllCart(session.getAttribute("userName").toString());
		if(arrayList.isEmpty()) {
			mv.setViewName("Message.jsp");
			mv.addObject("messagePage", "No Item added in your cart!!!");
		}
		else {
			mv.setViewName("Cart.jsp");
			mv.addObject("name", session.getAttribute("userName").toString());
			mv.addObject("products", arrayList);
			mv.addObject("message","");
		}
		return mv;
	}
	@RequestMapping("/removeFromCart")
	public ModelAndView removeFromCart(HttpServletRequest req, HttpServletResponse res){
		
		ModelAndView mv = new ModelAndView();
		HttpSession session = req.getSession();
		System.out.println(session.getAttribute("userName").toString());
		ArrayList<ProductDetails> arrayList = cartService.removeFromCart(req.getParameter("cartProdnm").toString());
		if(arrayList.isEmpty()) {
			mv.setViewName("Message.jsp");
			mv.addObject("messagePage", "No Item added in your cart!!!");
		}
		else {
			mv.setViewName("Cart.jsp");
			mv.addObject("name", session.getAttribute("userName").toString());
			mv.addObject("products", arrayList);
			mv.addObject("message","");
		}
		return mv;
	}
}
