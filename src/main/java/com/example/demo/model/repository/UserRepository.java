package com.example.demo.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.User;

public interface UserRepository extends CrudRepository<User, String>  {

}
