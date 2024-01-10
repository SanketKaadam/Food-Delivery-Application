package com.sanket.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sanket.Mapper.UserMapper;
import com.sanket.dto.UserDTO;
import com.sanket.entity.User;
import com.sanket.repository.UserRepo;
import com.sanket.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepo repo;

	@Override
	public UserDTO saveUser(UserDTO userdto) {
		User user = repo.save(UserMapper.INSTANCE.maptoUserFromUserDTO(userdto));
		UserDTO userDto = UserMapper.INSTANCE.mapToUserDTOFromUser(user);
		return userDto;
	}

	@Override
	public ResponseEntity<UserDTO> fetchUser(Integer id) {
		Optional<User> user = repo.findById(id);
		
		if(user.isPresent()) {
			return new ResponseEntity<>(UserMapper.INSTANCE.mapToUserDTOFromUser(user.get()),HttpStatus.OK);
		}
		return  new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}

}
