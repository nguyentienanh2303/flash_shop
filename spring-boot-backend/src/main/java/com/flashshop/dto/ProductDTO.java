package com.flashshop.dto;

public class ProductDTO {
	private Long id;
	private String type;
	private String name;
	private String linkImg;
	private String summary;
	private long price;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLinkImg() {
		return linkImg;
	}
	public void setLinkImg(String linkImg) {
		this.linkImg = linkImg;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
}
