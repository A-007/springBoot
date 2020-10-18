package com.infotect.mytodoapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infotect.mytodoapp.model.User;
import com.infotect.mytodoapp.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	MongoOperations mongoOperations;

	@PostMapping("/user")
	public ResponseEntity<?> registerUser(@Valid @RequestBody User request) {
		User user = mongoOperations.findOne(Query.query(Criteria.where("username").is(request.getUsername())),
				User.class, "Users");
		if (user == null) {
			return new ResponseEntity<>(userRepository.save(request), HttpStatus.CREATED);
		} else {

			return new ResponseEntity<>("User already exists", HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@PutMapping("/updateUser")
	public ResponseEntity<?> updateUser(@Valid @RequestBody User request) {
//		User user = mongoOperations.findOne(Query.query(Criteria.where("username").is(request.getUsername())),
//				User.class, "Users");
//		if (user == null) {
//			return new ResponseEntity<>(userRepository.save(request), HttpStatus.CREATED);
//		} else {
//
		return new ResponseEntity<>("User already exists", HttpStatus.NOT_ACCEPTABLE);
//		}
	}

}
