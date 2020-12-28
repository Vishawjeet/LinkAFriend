package com.linking.rest.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.linking.db.entity.User;
import com.linking.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController implements Controller<User, String> {

	@Autowired
	UserService userService;

	@GetMapping("/{id}")
	public User get(@PathVariable String id) {		
		return userService.get(UUID.fromString(id));
	}
	
	@GetMapping("/user/{userName}")
	public User getByUserName(@PathVariable String userName) {		
		return userService.getUserByUserName(userName);
	}

	@PutMapping("/{id}")
	public User update(@RequestBody User newUser, @PathVariable String id) {
		return userService.update(newUser, UUID.fromString(id));
	}
	
	@DeleteMapping(value = "/{id}", produces = "application/json; charset=utf-8")
	public String delete(@PathVariable String id) {
		boolean result  =  userService.delete(UUID.fromString(id));
		return "{ \"success\" : " + (result ? "true" : "false") + " }";		
	}

	@PostMapping("/")
	public User add(@RequestBody User newUser) {
		return userService.add(newUser);
	}
	
	@PostMapping("/login") 
	public String login(@RequestParam String userName, @RequestParam String password) {
		boolean result  =  userService.login(userName, password);
		return "{ \"success\" : " + (result ? "true" : "false") + " }";		
	}

}
