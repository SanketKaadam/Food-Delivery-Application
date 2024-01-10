package com.sanket.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sanket.DTO.RestaurentDTO;

public interface RestaurentService {

	RestaurentDTO addRestaurent(RestaurentDTO restaurentdDto);

	ResponseEntity<RestaurentDTO> getRestaurent(Integer id);

	List<RestaurentDTO> getRestaurents();

}
