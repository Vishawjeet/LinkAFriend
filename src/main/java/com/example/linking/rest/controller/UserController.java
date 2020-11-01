package com.example.linking.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.linking.db.entity.User;
import com.example.linking.service.UserService;

@RestController
public class UserController {
	
	
	
	@Autowired
	UserService userService;
	
	@GetMapping(value = "/healthcheck", produces = "application/json; charset=utf-8")
	 public String getHealthCheck()
	 {
	  return "{ \"isWorking\" : true }";
	 }
	 @GetMapping("/users")
	 public List<User> getUsers()
	 {
	  List<User> UsersList = userService.getAll();
	  return UsersList;
	 }
	
	 @GetMapping("	user/{id}")
	 public Optional<User> getUser(@PathVariable String id)
	 {
	   return userService.get(id);
	 }
	 
	 @PutMapping("/User/{id}")
	 public Optional<User> updateUser(@RequestBody User newUser, @PathVariable String id)
	 {
		 return	userService.update(newUser, id);
	 }
	 
	 @DeleteMapping(value = "/User/{id}", produces = "application/json; charset=utf-8")
	 public String deleteUser(@PathVariable String id) 
	 {
	  return userService.delete(id);
	 }
	 
	 @PostMapping("/User")
	 public User addUser(@RequestBody User newUser)
	 {
		 return userService.add(newUser);
	 }

}
