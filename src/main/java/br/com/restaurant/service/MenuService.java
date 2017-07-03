package br.com.restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.restaurant.dao.MenuDAO;
import br.com.restaurant.model.Menu;

@Service
public class MenuService {

	@Autowired
	MenuDAO dao;

	public void save(Menu menu) {
		dao.saveMenu(menu);
	}

	public List<Menu> list(String id) {
		return dao.getMenuForRestaurant(id);
	}

}
