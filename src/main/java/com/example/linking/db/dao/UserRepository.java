package com.example.linking.db.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.linking.db.entity.User;

public interface UserRepository extends CrudRepository<User, String>  {

}
