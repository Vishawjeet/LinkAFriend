package com.linking.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linking.db.entity.User;
import com.linking.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController implements Controller<User, String> {

	@Autowired
	UserService userService;

	@GetMapping("/all")
	public List<User> getAll() {
		List<User> UsersList = userService.getAll();
		return UsersList;
	}

	@GetMapping("/{id}")
	public Optional<User> get(@PathVariable String id) {
		return userService.get(id);
	}

	@PutMapping("/{id}")
	public Optional<User> update(@RequestBody User newUser, @PathVariable String id) {
		return userService.update(newUser, id);
	}

	@DeleteMapping(value = "/{id}", produces = "application/json; charset=utf-8")
	public String delete(@PathVariable String id) {
		return userService.delete(id);
	}

	@PostMapping("/")
	public User add(@RequestBody User newUser) {
		return userService.add(newUser);
	}

}
