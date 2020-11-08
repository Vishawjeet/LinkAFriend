package com.linking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linking.db.dao.UserRepository;
import com.linking.db.entity.User;

@Service
public class UserService implements BService<User, String> {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> getAll() {
		Iterable<User> result = userRepository.findAll();
		  List<User> UsersList = new ArrayList<>();
		  result.forEach(UsersList::add);
		return UsersList;
	}
	
	 @Override
	public Optional<User> get(String id)
	 {
		 Optional<User> emp = userRepository.findById(id);
		  return emp;
	 }
	 
	 @Override
	public Optional<User> update(User newUser, String id)
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
	 
	 @Override
	public String delete(String id) 
	 {
		 Boolean result = userRepository.existsById(id);
		 userRepository.deleteById(id);
		 return "{ \"success\" : "+ (result ? "true" : "false") +" }";
	 }
	 
	 @Override
	public User add(User newUser)
	 {
		 String id = String.valueOf(new Random().nextInt());
		 User emp = new User(id, newUser.getFirstName(), newUser.getLastName(), newUser.getEmail(), 
				  newUser.getPassword(), newUser.getGender(), newUser.getDateOfBirth());
		 userRepository.save(emp);
		 return emp;
	 }

}
