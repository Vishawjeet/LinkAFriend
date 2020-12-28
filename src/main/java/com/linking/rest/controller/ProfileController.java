package com.linking.rest.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linking.db.entity.UserProfile;

@RestController
@RequestMapping("/user/profile")
public class ProfileController implements Controller<UserProfile, String> {



	@GetMapping("/{id}")
	public UserProfile get(@PathVariable String id) {
		return null;
	}

	@PutMapping("/{id}")
	
	@Override
	public UserProfile update(UserProfile model, String id) {
		// TODO Auto-generated method stub
		return null;
	}


//	@PatchMapping("/updateProfileImage")
	//TODO: Updating profile image and Cover Image
	
	
	@DeleteMapping(value = "/{id}", produces = "application/json; charset=utf-8")
	public String delete(@PathVariable String id) {
		return null;
	}

	@PostMapping("/")
	public UserProfile add(@RequestBody UserProfile newUser) {
		return null;
	}
	

}
