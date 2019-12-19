package com.flashshop.dto;

public class OrderProductDTO {
	private long id;
	private long cartId;
	private int amount;
	private ProductDTO product;
	public long getCartId() {
		return cartId;
	}
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public ProductDTO getProduct() {
		return product;
	}
	public void setProduct(ProductDTO product) {
		this.product = product;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
}
