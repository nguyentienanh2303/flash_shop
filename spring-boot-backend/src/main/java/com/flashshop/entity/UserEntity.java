package com.flashshop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "passWord")
	private String passWord;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "adress")
	private String adress;
	
	@OneToMany(                                      //1 người sử dụng có nhiều đơn hàng
	        mappedBy = "user",
	        cascade = CascadeType.REMOVE
	    )
	private List<CartEntity> carts = new ArrayList<>();

	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
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

	public Long getId() {
		return id;
	}

	public List<CartEntity> getCarts() {
		return carts;
	}

	public void setCarts(List<CartEntity> carts) {
		this.carts = carts;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
	
	

}
