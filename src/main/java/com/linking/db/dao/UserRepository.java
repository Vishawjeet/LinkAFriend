package com.linking.db.dao;

import org.springframework.data.repository.CrudRepository;

import com.linking.db.entity.User;

public interface UserRepository extends  CrudRepository<User, String>  {

}
