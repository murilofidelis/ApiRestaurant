package br.com.restaurant.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.restaurant.dao.mapper.RestaurantMapper;
import br.com.restaurant.model.Restaurant;

@Repository
public class RestaurantDAO extends BasicDAO {

	public List<Restaurant> getAllRestaurants() {
		String sql = "SELECT * FROM restaurants";
		return this.jdbcTemplate.query(sql, new RestaurantMapper());
	}

	public Restaurant restaurantById(String id) {
		String sql = "SELECT * FROM restaurants WHERE id = ?";
		return this.jdbcTemplate.queryForObject(sql, new Object[] { id }, new RestaurantMapper());
	}

	public void saveRestaurant(Restaurant restaurant) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO restaurants (id, name, category, deliveryestimate, rating, imagepath, about, hours) ");
		sql.append("VALUES (?,?,?,?,?,?,?,?)");
		this.jdbcTemplate.update(sql.toString(),
				new Object[] { restaurant.getId(), restaurant.getName(), restaurant.getCategory(),
						restaurant.getDeliveryEstimate(), restaurant.getRating(), restaurant.getImagePath(),
						restaurant.getAbout(), restaurant.getHours() });

	}
}
