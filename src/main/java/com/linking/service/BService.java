package com.linking.service;

public interface BService<T,ID> {

	T get(ID id);

	T update(T newUser, ID id);

	boolean delete(ID id);

	T add(T newUser);

}