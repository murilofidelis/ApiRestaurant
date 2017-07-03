package br.com.restaurant.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.restaurant.dao.mapper.MenuMapper;
import br.com.restaurant.model.Menu;

@Repository
public class MenuDAO extends BasicDAO {

	public void saveMenu(Menu menu) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO menu (id, imagepath, name,description, price, restaurantid)");
		sql.append("VALUES (?,?,?,?,?,?)");
		this.jdbcTemplate.update(sql.toString(), new Object[] { menu.getId(), menu.getImagePath(), menu.getName(),
				menu.getDescription(), menu.getPrice(), menu.getRestaurantId() });
	}

	public List<Menu> getMenuForRestaurant(String id) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT m.* FROM menu m INNER JOIN restaurants r ON ");
		sql.append("m.restaurantid = r.id WHERE r.id = ?");
		return this.jdbcTemplate.query(sql.toString(), new Object[] { id }, new MenuMapper());
	}
}
