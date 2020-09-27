package com.infotect.mytodoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.infotect.mytodoapp.service.LoginService;

public class LoginController {

	@Autowired
	LoginService service;

	@GetMapping("/login")
	public void login(@RequestHeader String email, @RequestHeader String password) {
		UserDetails details = service.loadUserByUsername(email);
	}

}
