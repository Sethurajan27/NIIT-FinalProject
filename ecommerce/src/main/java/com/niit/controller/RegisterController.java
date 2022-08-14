package com.niit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.entity.UserDetails;
import com.niit.service.RegisterService;

@Controller
public class RegisterController {

	@Autowired
	private RegisterService registerService;
	@Autowired
	private UserDetails userDetails;

	@RequestMapping("/register")
	public ModelAndView userRegistration(HttpServletRequest req, HttpServletResponse res) {

		userDetails.setName(req.getParameter("name"));
		userDetails.setAddress(req.getParameter("address"));
		userDetails.setContact(req.getParameter("contact"));
		userDetails.setEmail(req.getParameter("email"));
		userDetails.setUserName(req.getParameter("userName"));
		userDetails.setPassword(req.getParameter("password"));

		String result = null;

		ModelAndView mv = new ModelAndView();

		result = registerService.userRegistration(userDetails.getName(), userDetails.getAddress(), userDetails.getContact(),
				userDetails.getEmail(), userDetails.getUserName(), userDetails.getPassword());

		if (result == null) {
			mv.setViewName("Home.jsp");
			mv.addObject("name", userDetails.getUserName());
		} else {
			result = "Registration Issue! " + result + ", kindly register again!!!";
			mv.setViewName("Registration1.jsp");
			mv.addObject("message", result);
		}

		return mv;
	}

}
