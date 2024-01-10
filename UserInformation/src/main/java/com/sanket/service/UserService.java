package com.sanket.service;

import org.springframework.http.ResponseEntity;

import com.sanket.dto.UserDTO;

public interface UserService {

	UserDTO saveUser(UserDTO userdto);

	ResponseEntity<UserDTO> fetchUser(Integer id);

}
