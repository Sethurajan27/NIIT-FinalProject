package com.niit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.entity.LoginDetails;
import com.niit.service.LoginService;
import com.niit.service.ProductService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	@Autowired
	private LoginDetails loginDetails;
	@Autowired
	private ProductService productService;

	@RequestMapping("/login")
	public ModelAndView loginUser(HttpServletRequest req, HttpServletResponse res) {

		HttpSession session = req.getSession();
		session.setAttribute("userName", req.getParameter("u"));
		session.setAttribute("userPassword", req.getParameter("p"));

		loginDetails.setUserName(req.getParameter("u"));
		loginDetails.setPassword(req.getParameter("p"));

		ModelAndView mv = new ModelAndView();

		System.out.println(loginDetails.getUserName());
		System.out.println(loginDetails.getPassword());

		String result = null;
		result = loginService.Validate(session.getAttribute("userName").toString(),
				session.getAttribute("userPassword").toString());

		if (result.equals("Success")) {
			mv.setViewName("Home.jsp");
			mv.addObject("name", loginDetails.getUserName());
			mv.addObject("products", productService.getAllProducts());
			mv.addObject("message", "");
		} else {
			mv.setViewName("index1.jsp");
		}
		return mv;
	}

}
