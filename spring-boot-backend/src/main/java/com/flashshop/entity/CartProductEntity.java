package com.flashshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart_product")
public class CartProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "amount")
	private int amount;

	@ManyToOne
	@JoinColumn(name = "cartId")
	private CartEntity cart;

	@ManyToOne
	@JoinColumn(name = "productId")
	private ProductEntity product;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public CartEntity getCart() {
		return cart;
	}

	public void setCart(CartEntity cart) {
		this.cart = cart;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public Long getId() {
		return id;
	}




}
