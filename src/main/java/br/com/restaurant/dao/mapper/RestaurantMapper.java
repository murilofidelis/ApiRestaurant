package br.com.restaurant.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.restaurant.model.Restaurant;

public class RestaurantMapper implements RowMapper<Restaurant> {

	@Override
	public Restaurant mapRow(ResultSet rs, int rwNumber) throws SQLException {
		Restaurant r = new Restaurant();
		r.setId(rs.getString("id"));
		r.setName(rs.getString("name"));
		r.setCategory(rs.getString("category"));
		r.setDeliveryEstimate(rs.getString("deliveryestimate"));
		r.setRating(rs.getDouble("rating"));
		r.setImagePath(rs.getString("imagepath"));
		r.setAbout(rs.getString("about"));
		r.setHours(rs.getString("hours"));
		return r;
	}
}
