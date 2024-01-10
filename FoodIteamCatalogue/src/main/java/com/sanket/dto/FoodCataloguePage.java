package com.sanket.dto;

import java.util.List;

import com.sanket.entity.FoodIteam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodCataloguePage {
	
	List<FoodIteam> footIteamList;
	Restaurent restaurent;

}
