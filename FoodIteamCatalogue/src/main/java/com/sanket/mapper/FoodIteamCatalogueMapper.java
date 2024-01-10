package com.sanket.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.sanket.dto.FoodIteamDTO;
import com.sanket.entity.FoodIteam;

@Mapper
public interface FoodIteamCatalogueMapper {
	
    FoodIteamCatalogueMapper INSTANCE = Mappers.getMapper(FoodIteamCatalogueMapper.class);
    
    FoodIteam mapFootIteamDtoToFootIteam(FoodIteamDTO dto);
    
    FoodIteamDTO mapFootIteamToFootIteamDto(FoodIteam footIteam);

}
