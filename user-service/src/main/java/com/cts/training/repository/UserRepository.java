package com.cts.training.repository;


import java.util.List;

import comcts.training.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository {

	public interface userRepository extends JpaRepository<User, Long>{
		
	}

	public List<User> findAll();
}