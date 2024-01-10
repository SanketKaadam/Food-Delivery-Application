package com.sanket.service;

import org.springframework.stereotype.Service; 

import com.sanket.dto.FoodCataloguePage;
import com.sanket.dto.FoodIteamDTO;


@Service
public interface FoodCatalogueService {

	FoodIteamDTO saveFootIteam(FoodIteamDTO dto);

	

	FoodCataloguePage fetchRestauDetailsWithFoodMenu(Integer restaurentId);

}
