package br.com.restaurant.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.restaurant.model.Menu;

public class MenuMapper implements RowMapper<Menu> {

	@Override
	public Menu mapRow(ResultSet r, int rowNum) throws SQLException {
		Menu m = new Menu();
		m.setId(r.getString("id"));
		m.setName(r.getString("name"));
		m.setDescription(r.getString("description"));
		m.setImagePath(r.getString("imagepath"));
		m.setPrice(r.getDouble("price"));
		return m;
	}
}
