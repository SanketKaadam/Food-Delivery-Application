package com.sanket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanket.dto.UserDTO;
import com.sanket.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("saveUser")
	public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userdto){
		UserDTO savedUser = userService.saveUser(userdto);
		return new ResponseEntity<UserDTO>(savedUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/getUserById/{id}")
	public ResponseEntity<UserDTO> getUser(@PathVariable Integer id){
		return userService.fetchUser(id);
	}

}
