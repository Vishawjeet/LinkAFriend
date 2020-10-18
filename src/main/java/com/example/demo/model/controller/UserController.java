package com.example.demo.model.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.model.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping(value = "/healthcheck", produces = "application/json; charset=utf-8")
	 public String getHealthCheck()
	 {
	  return "{ \"isWorking\" : true }";
	 }
	 @GetMapping("/users")
	 public List<User> getUsers()
	 {
	  Iterable<User> result = userRepository.findAll();
	  List<User> UsersList = new ArrayList<>();
	  result.forEach(UsersList::add);
	  return UsersList;
	 }
	 @GetMapping("	user/{id}")
	 public Optional<User> getUser(@PathVariable String id)
	 {
	  Optional<User> emp = userRepository.findById(id);
	  return emp;
	 }
	 
	 @PutMapping("/User/{id}")
	 public Optional<User> updateUser(@RequestBody User newUser, @PathVariable String id)
	 {
	  Optional<User> optionalEmp = userRepository.findById(id);
	  if (optionalEmp.isPresent()) {
	   User user = optionalEmp.get();
	   user.setFirstName(newUser.getFirstName());
	   user.setLastName(newUser.getLastName());
	   user.setEmail(newUser.getEmail());
	   user.setPassword(newUser.getPassword());
	   user.setGender(newUser.getGender());
	   user.setDateOfBirth(newUser.getDateOfBirth());
	   userRepository.save(user);
	  }
	  return optionalEmp;
	 }
	 
	 @DeleteMapping(value = "/User/{id}", produces = "application/json; charset=utf-8")
	 public String deleteUser(@PathVariable String id) {
	  Boolean result = userRepository.existsById(id);
	  userRepository.deleteById(id);
	  return "{ \"success\" : "+ (result ? "true" : "false") +" }";
	 }
	 
	 @PostMapping("/User")
	 public User addUser(@RequestBody User newUser)
	 {
	  String id = String.valueOf(new Random().nextInt());
	  User emp = new User(id, newUser.getFirstName(), newUser.getLastName(), newUser.getEmail(), 
			  newUser.getPassword(), newUser.getGender(), newUser.getDateOfBirth());
	  userRepository.save(emp);
	  return emp;
	 }

}
