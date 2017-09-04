package br.com.restaurant.model;

import java.util.ArrayList;
import java.util.List;

public class Orders {

	private Integer id;
	private String endereco;
	private Integer numero;
	private String complemento;
	private String opcaoPagamentoSelecionada;
	private List<OrderItems> orderItems = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getOpcaoPagamentoSelecionada() {
		return opcaoPagamentoSelecionada;
	}

	public void setOpcaoPagamentoSelecionada(String opcaoPagamentoSelecionada) {
		this.opcaoPagamentoSelecionada = opcaoPagamentoSelecionada;
	}

	public List<OrderItems> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}

}
