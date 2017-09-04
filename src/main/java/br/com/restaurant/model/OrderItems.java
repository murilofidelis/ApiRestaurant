package br.com.restaurant.model;

public class OrderItems {

	private String menuId;
	private Integer qunatity;

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public Integer getQunatity() {
		return qunatity;
	}

	public void setQunatity(Integer qunatity) {
		this.qunatity = qunatity;
	}

	@Override
	public String toString() {
		return "OrderItems [menuId=" + menuId + ", qunatity=" + qunatity + "]";
	}

	
	
}
