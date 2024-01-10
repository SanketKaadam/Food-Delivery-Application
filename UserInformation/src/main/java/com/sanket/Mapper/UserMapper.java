package com.sanket.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.sanket.dto.UserDTO;
import com.sanket.entity.User;

@Mapper
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	User maptoUserFromUserDTO(UserDTO dto);
	
	UserDTO mapToUserDTOFromUser(User user);
}
