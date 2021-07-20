package com.tutorial.rest.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tutorial.rest.demo.domain.User;

@Service
public class UserService {

	public User createUser(User user) {
		
		return (new User("100", "Eliza", "Rooney", "F", "1996/06/05"));
	}
	
	public Optional<User> updateUser(User user) {
		
		return Optional.of(user);
	}
	
	public List<User> getUsers() {
		
		List<User> users = new ArrayList<>();
		
		users.add(new User("100", "Eliza", "Rooney", "F", "1996/06/05"));
		users.add(new User("101", "Fred", "White", "M", "1997/02/15"));
		users.add(new User("102", "John", "Burton", "M", "2000/05/13"));
		users.add(new User("103", "Samantha", "Rooney", "F", "2003/07/02"));
		
		return users;
	}
	
	public Optional<User> getUser(String id) {
		
		return Optional.of(new User("100", "Eliza", "Rooney", "F", "1996/06/05"));
	}
	
	public void deleteUser(String id) {
		
		return;
	}
	
}
