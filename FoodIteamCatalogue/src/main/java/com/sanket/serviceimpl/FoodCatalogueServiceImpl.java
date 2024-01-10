package com.sanket.serviceimpl;

 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sanket.dto.FoodCataloguePage;
import com.sanket.dto.FoodIteamDTO;
import com.sanket.dto.Restaurent;
import com.sanket.entity.FoodIteam;
import com.sanket.mapper.FoodIteamCatalogueMapper;
import com.sanket.repository.FoodCatalogueRepo;
import com.sanket.service.FoodCatalogueService;


@Service
public class FoodCatalogueServiceImpl implements FoodCatalogueService {
	
	@Autowired
	FoodCatalogueRepo foodCatalogueRepo;
	
	@Autowired
	RestTemplate restTemplate;


	@Override
	public FoodIteamDTO saveFootIteam(FoodIteamDTO dto) {
         FoodIteam savedFootIteam = foodCatalogueRepo.save(FoodIteamCatalogueMapper.INSTANCE.mapFootIteamDtoToFootIteam(dto));
		
		return FoodIteamCatalogueMapper.INSTANCE.mapFootIteamToFootIteamDto(savedFootIteam);
	}


	@Override
	public FoodCataloguePage fetchRestauDetailsWithFoodMenu(Integer restaurentId) {
		List<FoodIteam> foodteamList = getFoodIteamList(restaurentId);
		Restaurent restaurent = getRestaurent(restaurentId);
		return createFoodCataloguePage(foodteamList,restaurent);
	}
	
	


	private FoodCataloguePage createFoodCataloguePage(List<FoodIteam> foodteamList, Restaurent restaurent) {
		FoodCataloguePage cataloguePage = new FoodCataloguePage();
		cataloguePage.setFootIteamList(foodteamList);
		cataloguePage.setRestaurent(restaurent);
		return cataloguePage;
	}


	private Restaurent getRestaurent(Integer restaurentId) {
		
		return restTemplate.getForObject("http://RESTAURENT-SERVICE/getRestaurentById/"+restaurentId, Restaurent.class);
	}


	private List<FoodIteam> getFoodIteamList(Integer restaurentId) {
		
		return  foodCatalogueRepo.findByrestaurentId(restaurentId);
	}
	
	
	

	



}
