package com.sanket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sanket.entity.User;


@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

}
