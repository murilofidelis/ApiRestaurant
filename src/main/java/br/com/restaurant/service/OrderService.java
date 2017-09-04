package br.com.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.restaurant.dao.OrderDAO;
import br.com.restaurant.model.Orders;

@Service
public class OrderService {

	@Autowired
	OrderDAO dao;

	public void saveOrder(Orders order) {
		dao.saveOrder(order);
	}
}
