package com.linking.service;

import java.util.List;
import java.util.Optional;

public interface BService<T,ID> {

	List<T> getAll();

	Optional<T> get(ID id);

	Optional<T> update(T newUser, ID id);

	ID delete(ID id);

	T add(T newUser);

}