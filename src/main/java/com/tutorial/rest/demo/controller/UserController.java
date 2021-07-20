package com.tutorial.rest.demo.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.rest.demo.domain.User;
import com.tutorial.rest.demo.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	public final UserService userService;
	
	public static final String ENTITY_NAME = "User";
	
	public final Logger log = LoggerFactory.getLogger(UserController.class);
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) throws URISyntaxException {
		log.info("REST request to save User: {}", user);
		
		User userResponse = userService.createUser(user);
		return ResponseEntity.created(new URI("/api/users/" + userResponse.getId())).header(ENTITY_NAME, userResponse.getId()).body(user);				
	}
	
	@PutMapping("/users")
	public ResponseEntity<User> updateUser(@RequestBody User user) throws URISyntaxException {
		log.info("REST request to update User: {}", user);
		
		Optional<User> userResponse = userService.updateUser(user);
		return ResponseEntity.of(userResponse);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		log.info("REST request to get all Users");
		
		return new ResponseEntity<List<User>>(userService.getUsers(), HttpStatus.OK);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUser(@PathVariable String id) {
		log.info("REST request to get User: {}", id);
		
		Optional<User> optionalUser = userService.getUser(id);
		return ResponseEntity.of(optionalUser);
	}
	
	@DeleteMapping("/users/{id}") 
	public ResponseEntity<Void> deleteUser(@PathVariable String id) {
		log.info("REST request to delete User: {}", id);
		
		userService.deleteUser(id);
		return ResponseEntity.noContent().header(ENTITY_NAME + ".deleted", id).build();
	}
	
}
