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

import br.com.restaurant.model.Menu;
import br.com.restaurant.model.Restaurant;
import br.com.restaurant.model.Review;
import br.com.restaurant.service.MenuService;
import br.com.restaurant.service.RestaurantService;
import br.com.restaurant.service.ReviewService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

	@Autowired
	RestaurantService restaurantService;
	@Autowired
	MenuService menuService;
	@Autowired
	ReviewService reviewService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Restaurant>> listRestaurants() {
		List<Restaurant> listResult = restaurantService.list();
		return new ResponseEntity<List<Restaurant>>(listResult, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Restaurant> getRestaurantById(@PathVariable String id) {
		Restaurant restaurant = restaurantService.getRestaurant(id);
		if (restaurant == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Restaurant>(restaurant, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Restaurant> saveRestaurant(@RequestBody Restaurant restaurant) {
		restaurantService.save(restaurant);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}/menu", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Menu>> listMenus(@PathVariable String id) {
		List<Menu> list = menuService.list(id);
		return new ResponseEntity<List<Menu>>(list, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/menu", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Menu> saveMenu(@RequestBody Menu menu) {
		menuService.save(menu);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/reviews", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Menu> saveReview(@RequestBody Review review) {
		reviewService.save(review);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}/reviews", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Review>> listReviews(@PathVariable String id) {
		List<Review> list = reviewService.list(id);
		return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
	}
}
