package com.flashshop.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CartDTO {
	private long id;
	private long userId;
    private long status;
	private String firstName;
	private String lastName;
	private String adress;
	private Date createData;
	private Date modifiedData;
	private String phone;
	private List<CartProductDTO> listCartProduct = new ArrayList<>();

	
	

	
	public List<CartProductDTO> getListCartProduct() {
		return listCartProduct;
	}
	public void setListCartProduct(List<CartProductDTO> listCartProduct) {
		this.listCartProduct = listCartProduct;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getStatus() {
		return status;
	}
	public void setStatus(long status) {
		this.status = status;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
    

}
