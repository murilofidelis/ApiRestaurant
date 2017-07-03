package br.com.restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.restaurant.dao.ReviewDAO;
import br.com.restaurant.model.Review;

@Service
public class ReviewService {

	@Autowired
	ReviewDAO dao;

	public void save(Review review) {
		dao.saveReview(review);
	}

	public List<Review> list(String id) {
		return dao.getReviews(id);
	}
}
