package com.sanket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import com.sanket.entity.FoodIteam;


@Repository
public interface FoodCatalogueRepo extends JpaRepository<FoodIteam, Integer> {
	
	List<FoodIteam> findByrestaurentId(Integer restaurantId);

}
