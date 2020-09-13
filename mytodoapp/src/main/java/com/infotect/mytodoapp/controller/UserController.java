package com.infotect.mytodoapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infotect.mytodoapp.model.User;
import com.infotect.mytodoapp.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;

	@PostMapping("/user")
	public void registerUser(@Valid @RequestBody User request) {
		userRepository.save(request);
	}

}
