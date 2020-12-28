package com.linking.rest.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface Controller <T, ID> {	
	T add(@RequestBody T model);
	ID delete(@PathVariable ID id);
	T update(@RequestBody T model, @PathVariable ID id);
	T get(@PathVariable ID id);
}