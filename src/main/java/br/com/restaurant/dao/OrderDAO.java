package br.com.restaurant.dao;

import org.springframework.stereotype.Repository;

import br.com.restaurant.model.OrderItems;
import br.com.restaurant.model.Orders;

@Repository
public class OrderDAO extends BasicDAO {

	public void saveOrder(Orders order) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO orders (endereco, numero, complemento, opcaopagamentoselecionada) ");
		sql.append("VALUES (?,?,?,?)");
		this.jdbcTemplate.update(sql.toString(), new Object[] { order.getEndereco(), order.getNumero(),
				order.getComplemento(), order.getOpcaoPagamentoSelecionada() });

		for (int i = 0; i < order.getOrderItems().size(); i++) {
			OrderItems item = order.getOrderItems().get(i);
			String sqlItens = "INSERT INTO orderitems (id, menuid, qunatity) VALUES (?,?,?)";
			this.jdbcTemplate.update(sqlItens, new Object[] { getMaxID(), item.getMenuId(), item.getQunatity() });
		}
	}

	// buscar max ID
	private Integer getMaxID() {
		String querry = "SELECT MAX(id) FROM orders";
		return this.jdbcTemplate.queryForObject(querry, Integer.class);
	}

}
