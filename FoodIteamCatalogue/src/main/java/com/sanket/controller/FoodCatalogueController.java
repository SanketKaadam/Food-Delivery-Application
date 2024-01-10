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

import com.sanket.dto.FoodCataloguePage;
import com.sanket.dto.FoodIteamDTO;
import com.sanket.service.FoodCatalogueService;

@RestController
@RequestMapping("/foodCatalogue")
public class FoodCatalogueController {
	
	@Autowired
	FoodCatalogueService foodCatalogueService;
	
	
	@PostMapping("/addFoodItem")
	public ResponseEntity<FoodIteamDTO> addFootIteam(@RequestBody FoodIteamDTO dto){
		System.out.println("called");
		FoodIteamDTO footIteamSaved = foodCatalogueService.saveFootIteam(dto);
		
		return new ResponseEntity<FoodIteamDTO>(footIteamSaved,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/fetchFoodIteamAndRestaurentById/{restaurentId}")
	public ResponseEntity<FoodCataloguePage> fetchFoodIteamAndRestaurentById(@PathVariable Integer restaurentId ){
		FoodCataloguePage cataloguePage = foodCatalogueService.fetchRestauDetailsWithFoodMenu(restaurentId);
		return new ResponseEntity<FoodCataloguePage>(cataloguePage, HttpStatus.OK);
	}

}
