package br.com.restaurant.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.restaurant.model.Restaurant;
import br.com.restaurant.service.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

	@Autowired
	RestaurantService service;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Restaurant>> getAll() {
		List<Restaurant> listResult = service.list();
		return new ResponseEntity<List<Restaurant>>(listResult, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Restaurant> getRestaurantById(@PathVariable String id) {
		Restaurant restaurant = service.getRestaurant(id);
		if (restaurant == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Restaurant>(restaurant, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Restaurant> save(@RequestBody Restaurant restaurant) {
		service.save(restaurant);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
