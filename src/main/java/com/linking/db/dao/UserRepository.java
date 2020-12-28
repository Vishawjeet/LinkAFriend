package com.linking.db.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.repository.CrudRepository;

import com.linking.db.entity.User;

public interface UserRepository extends  CrudRepository<User, UUID>  {
	@AllowFiltering
	List<User> findByUserName(String userName);
}
