package br.com.restaurant.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.restaurant.model.Orders;
import br.com.restaurant.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	OrderService orderService;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Orders> saveOrder(@RequestBody Orders order) {

		System.out.println(order.getEndereco() + " - " + order.getOrderItems().get(1));
		
		orderService.saveOrder(order);

		return new ResponseEntity<Orders>(HttpStatus.CREATED);
	}

}
