package com.linking.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linking.db.entity.FeedBack;
import com.linking.service.FeedBackService;

@RestController
@RequestMapping("/feedback")
public class FeedbackController implements Controller<FeedBack, String> {

	@Autowired
	FeedBackService feedbackService;

	@GetMapping("/all")
	public List<FeedBack> getAll() {
		List<FeedBack> FeedbacksList = feedbackService.getAll();
		return FeedbacksList;
	}

	@GetMapping("/{id}")
	public FeedBack get(@PathVariable String id) {
		return feedbackService.get(id);
	}

	@PutMapping("/{id}")
	public FeedBack update(@RequestBody FeedBack newFeedback, @PathVariable String id) {
		return feedbackService.update(newFeedback, id);
	}

	@DeleteMapping(value = "/{id}", produces = "application/json; charset=utf-8")
	public String delete(@PathVariable String id) {
		boolean result  =  feedbackService.delete(id);
		return "{ \"success\" : " + (result ? "true" : "false") + " }";	
	}

	@PostMapping("/")
	public FeedBack add(@RequestBody FeedBack newFeedback) {
		return feedbackService.add(newFeedback);
	}

}
