package com.linking.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface Controller <T, ID> {	
	T add(@RequestBody T model);
	ID delete(@PathVariable ID id);
	Optional<T> update(@RequestBody T model, @PathVariable ID id);
	Optional<T> get(@PathVariable ID id);
	List<T> getAll();
}