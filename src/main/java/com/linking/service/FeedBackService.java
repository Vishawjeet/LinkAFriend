package com.linking.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linking.db.dao.FeedBackRepository;
import com.linking.db.entity.FeedBack;

@Service
public class FeedBackService implements BService<FeedBack, String> {

	@Autowired
	FeedBackRepository feedBackRepository;

	@Override
	public List<FeedBack> getAll() {
		Iterable<FeedBack> result = feedBackRepository.findAll();
		List<FeedBack> feedBackList = new ArrayList<>();
		result.forEach(feedBackList::add);
		return feedBackList;
	}

	@Override
	public Optional<FeedBack> get(String id) {
		Optional<FeedBack> feedback = feedBackRepository.findById(id);
		return feedback;
	}

	@Override
	public Optional<FeedBack> update(FeedBack newFeedBack, String id) {
		Optional<FeedBack> optionalFeedback = feedBackRepository.findById(id);
		if (optionalFeedback.isPresent()) {
			FeedBack feedBack = optionalFeedback.get();
			feedBack.setUserId(newFeedBack.getUserId());
			feedBack.setFeedBack(newFeedBack.getFeedBack());
			feedBack.setFeedbackDate(newFeedBack.getFeedbackDate());
			feedBackRepository.save(feedBack);
		}
		return optionalFeedback;
	}

	@Override
	public String delete(String id) {
		Boolean result = feedBackRepository.existsById(id);
		feedBackRepository.deleteById(id);
		return "{ \"success\" : " + (result ? "true" : "false") + " }";
	}

	@Override
	public FeedBack add(FeedBack newFeedBack) {
		String id = String.valueOf(new Random().nextInt());
		Date date = new Date();
		FeedBack emp = new FeedBack(id, newFeedBack.getUserId(), newFeedBack.getFeedBack(), date);
		feedBackRepository.save(emp);
		return emp;
	}

}
