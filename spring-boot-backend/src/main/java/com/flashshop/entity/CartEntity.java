package com.flashshop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "cart")
public class CartEntity{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@ManyToOne                      //mỗi đơn hàng chỉ có 1 người sử dụng
    @JoinColumn(name = "user_id")
    private UserEntity user;
	
	
	@OneToMany(                                   //mỗi đơn hàng có nhiều sản phẩm
	        mappedBy = "cart",
	        cascade = CascadeType.REMOVE
	    )
	private List<CartProductEntity> cartProducts = new ArrayList<>();
	
	
	
	@OneToMany(                                   //mỗi đơn đặt hàng hàng có nhiều sản phẩm
	        mappedBy = "cart",
	        cascade = CascadeType.REMOVE
	    )
	private List<OrderProductEntity> orderProducts = new ArrayList<>();
	
	
	@Column(name = "status")
	private Long status;

	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "adress")
	private String adress;
	
	@Column(name = "phone")
	private String phone;
	
    @CreatedDate
    @Column
	private Date createData;
    
    @Column
    @LastModifiedDate
	private Date modifiedData;

	public UserEntity getUser() {
		return user;
	}


	public void setUser(UserEntity user) {
		this.user = user;
	}


	public List<CartProductEntity> getCartProducts() {
		return cartProducts;
	}


	public void setCartProducts(List<CartProductEntity> cartProducts) {
		this.cartProducts = cartProducts;
	}


	public Long getStatus() {
		return status;
	}


	public void setStatus(Long status) {
		this.status = status;
	}


	public Long getId() {
		return id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getAdress() {
		return adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}


	public Date getCreateData() {
		return createData;
	}


	public void setCreateData(Date createData) {
		this.createData = createData;
	}


	public Date getModifiedData() {
		return modifiedData;
	}


	public void setModifiedData(Date modifiedData) {
		this.modifiedData = modifiedData;
	}


	public List<OrderProductEntity> getOrderProduct() {
		return orderProducts;
	}


	public void setOrderProduct(List<OrderProductEntity> orderProduct) {
		this.orderProducts = orderProduct;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
	


	
	
}


