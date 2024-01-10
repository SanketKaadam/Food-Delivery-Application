package com.sanket.ServiceImpl;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sanket.DTO.RestaurentDTO;
import com.sanket.Mapper.RestaurentMapper;
import com.sanket.entity.Restaurent;
import com.sanket.repository.RestaurentRepo;
import com.sanket.service.RestaurentService;

@Service
public class RestaurentServiceImpl implements RestaurentService{

	@Autowired
	RestaurentRepo repo;
	
	@Override
	public RestaurentDTO addRestaurent(RestaurentDTO restaurentdDto) {
		Restaurent restaurent = RestaurentMapper.INSTEANCE.mapRestaurentDtoToRestaurent(restaurentdDto);
		Restaurent savedRestauret = repo.save(restaurent);
		
		return RestaurentMapper.INSTEANCE.mapRestaurentToRestaurentDto(savedRestauret);
	}
	

	@Override
	public ResponseEntity<RestaurentDTO> getRestaurent(Integer id) {
		Optional<Restaurent> getRestaurent = repo.findById(id);
		
		if(getRestaurent.isPresent()) {
			return new ResponseEntity<>(RestaurentMapper.INSTEANCE.mapRestaurentToRestaurentDto(getRestaurent.get()), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
		
		
	}


	@Override
	public List<RestaurentDTO> getRestaurents() {
		List<Restaurent> fetchRestaurents = repo.findAll();
		List<RestaurentDTO> fetchRestaurentDto = fetchRestaurents.stream().map(restaurent -> RestaurentMapper.INSTEANCE.mapRestaurentToRestaurentDto(restaurent)).collect(Collectors.toList());
		return fetchRestaurentDto;
	}

}
