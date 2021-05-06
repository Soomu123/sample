package com.cts.training.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.training.repository.UserRepository;
import com.sun.el.stream.Optional;

@RestController
@RequestMapping("/api")
public class UserResource {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id){
		Optional<User> user = userRepository.findById(id);
		return new RepositoryEntity<>(user, HttpStatus.Found);
	}
	
	@GetMapping("/users/address/{address}")
	public ResponseEntity<Optional<User>> getUserByAddress(@PathVariable String address){
		Optional<User> user = userRepository.findByAddress(address);
		return new RepositoryEntity<>(user, HttpStatus.Found);
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Long id) {
		userRepository.deleteById(id);
	}

}
