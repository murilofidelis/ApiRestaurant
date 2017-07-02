package br.com.restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.restaurant.dao.RestaurantDAO;
import br.com.restaurant.model.Restaurant;

@Service
public class RestaurantService {

	@Autowired
	RestaurantDAO dao;

	public List<Restaurant> list() {
		return dao.getAllRestaurants();
	}

	public Restaurant getRestaurant(String id) {
		return dao.restaurantById(id);
	}

	public void save(Restaurant restaurant) {
		dao.saveRestaurant(restaurant);
	}

}
