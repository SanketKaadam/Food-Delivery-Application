package com.sanket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanket.DTO.RestaurentDTO;
import com.sanket.service.RestaurentService;

@RestController
@RequestMapping("/restaurent")
@CrossOrigin
public class RestaurentController {
	
	@Autowired
	RestaurentService restaurentService;
	
	
	@PostMapping("/addRestaurent")
	public ResponseEntity<RestaurentDTO> getAllRestaurents(@RequestBody RestaurentDTO restaurentdDto){
		RestaurentDTO savedResturentDTO = restaurentService.addRestaurent(restaurentdDto);
		return new ResponseEntity<RestaurentDTO>(savedResturentDTO,HttpStatus.CREATED);
	}
	
	@GetMapping("/getRestaurentById/{id}")
	public ResponseEntity<RestaurentDTO> getRestaurent(@PathVariable Integer id){
		return restaurentService.getRestaurent(id);
	}
	
	@GetMapping("getAllRestaurent")
	public ResponseEntity<List<RestaurentDTO>> getAllRestaurents(){
		List<RestaurentDTO> fetchRestaurents = restaurentService.getRestaurents();
		return new ResponseEntity<List<RestaurentDTO>>(fetchRestaurents,HttpStatus.OK);
	}

}
