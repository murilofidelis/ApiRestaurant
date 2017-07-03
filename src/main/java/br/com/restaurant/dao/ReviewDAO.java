package br.com.restaurant.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.restaurant.dao.mapper.ReviewMapper;
import br.com.restaurant.model.Review;

@Repository
public class ReviewDAO extends BasicDAO {

	public void saveReview(Review review) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO reviews (name, date, rating, comments, restaurantid)");
		sql.append("VALUES (?,?,?,?,?)");
		this.jdbcTemplate.update(sql.toString(), new Object[] { review.getName(), review.getDate(), review.getRating(),
				review.getComments(), review.getRestaurantId() });
	}

	public List<Review> getReviews(String id) {
		String sql = "SELECT r.* FROM reviews r WHERE r.restaurantid = ?";
		return this.jdbcTemplate.query(sql, new Object[] { id }, new ReviewMapper());
	}

}
