package com.microservices.catalogservice.model;

public class CatalogItem {

	private String name;
	private String desc;
	private Double rating;
	
	public CatalogItem() {
		
	}
	
	public CatalogItem(String name, String desc, Double rating) {
		this.name = name;
		this.desc = desc;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}
	
}
