package br.com.restaurant.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public abstract class BasicDAO {

	protected JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		if (dataSource != null) {
			this.jdbcTemplate = new JdbcTemplate(dataSource, false);
		}
	}
}
