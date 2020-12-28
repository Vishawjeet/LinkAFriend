package com.linking.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linking.db.dao.UserRepository;
import com.linking.db.entity.User;
import com.linking.exception.ResourceNotFoundException;

@Service
public class UserService implements BService<User, UUID> {

	@Autowired
	UserRepository userRepository;

	@Override
	public User get(UUID id) {
		Optional<User> emp = userRepository.findById(id);
		return emp.get();
	}

	@Override
	public User update(User newUser, UUID id) {
		Optional<User> optionalEmp = userRepository.findById(id);
		if (optionalEmp.isPresent()) {
			User user = optionalEmp.get();
			user.setFirstName(newUser.getFirstName());
			user.setLastName(newUser.getLastName());
			user.setEmail(newUser.getEmail());
			user.setPassword(newUser.getPassword());
			user.setGender(newUser.getGender());
			user.setMobileNumber(newUser.getMobileNumber());
			user.setDateOfBirth(newUser.getDateOfBirth());
			if(newUser.getUserName()!=null && (!newUser.getUserName().equalsIgnoreCase(user.getUserName()))) {
				updateUserId(id, newUser.getUserName());
			}
			user = userRepository.save(user);
			return user;
		}
		return null;
	}

	public void updateUserId(UUID id, String userName)  {
		User user = getUserByUserName(userName) ;
		if(user==null) {
			user = userRepository.findById(id).get();
		}
		else {
			throw new ResourceNotFoundException(userName, userName, userName);
		}
		
	}
	
	public User getUserByUserName(String userName) {
		List<User> users = userRepository.findByUserName(userName);
		if(users!=null && users.size()==1)
		{
			return users.get(0);
		}
		return null;
	}
		

	@Override
	public boolean delete(UUID id) {
		Boolean result = userRepository.existsById(id);
		userRepository.deleteById(id);		
		return result;
	}
	
	public boolean login(String userName, String password) {
		boolean isLoginSuccessful = false;
		User user = getUserByUserName(userName);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				isLoginSuccessful = true;
			}
		}

		return isLoginSuccessful;
	}

	@Override
	public User add(User newUser) {
		UUID uuid = UUID.randomUUID();
		Long now = System.currentTimeMillis();
		User emp = new User(uuid, newUser.getUserName(), newUser.getFirstName(), newUser.getLastName(), newUser.getEmail(),
				newUser.getPassword(), newUser.getGender(), newUser.getMobileNumber(), newUser.getDateOfBirth(),
				now);
		emp = userRepository.save(emp);
		return emp;
	}

}
