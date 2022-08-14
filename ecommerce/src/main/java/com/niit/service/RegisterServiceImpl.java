package com.niit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.RegisterDAO;

@Service
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	private RegisterDAO registerDAO;

	public String userRegistration(String name, String address, String contact, String email, String userName,
			String password) {
		return registerDAO.userRegistration(name, address, contact, email, userName, password);
	}

}
