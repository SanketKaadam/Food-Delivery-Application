package com.sanket.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.sanket.DTO.RestaurentDTO;
import com.sanket.entity.Restaurent;

@Mapper
public interface RestaurentMapper {
	
	RestaurentMapper INSTEANCE = Mappers.getMapper(RestaurentMapper.class);
	
	Restaurent mapRestaurentDtoToRestaurent (RestaurentDTO dto);
	
	RestaurentDTO mapRestaurentToRestaurentDto (Restaurent restaurent);

}
