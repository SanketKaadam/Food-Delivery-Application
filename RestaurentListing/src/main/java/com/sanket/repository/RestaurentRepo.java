package com.sanket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sanket.entity.Restaurent;

@Repository
public interface RestaurentRepo extends JpaRepository<Restaurent, Integer>{

}
