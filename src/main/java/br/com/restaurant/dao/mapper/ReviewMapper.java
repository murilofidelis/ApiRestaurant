package br.com.restaurant.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.restaurant.model.Review;

public class ReviewMapper implements RowMapper<Review> {

	@Override
	public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
		Review r = new Review();
		r.setName(rs.getString("name"));
		r.setDate(rs.getDate("date"));
		r.setRating(rs.getDouble("rating"));
		r.setComments(rs.getString("comments"));
		return r;
	}

}
