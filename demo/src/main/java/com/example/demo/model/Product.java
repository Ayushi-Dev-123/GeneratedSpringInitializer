package com.example.demo.model;

public class Product {
	private int id;
	private String name;
	private int price;
	private String description;
	private int qty;
	
	public Product() {}
	
	public Product(int id, String name, int price, String description, int qty) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.qty = qty;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
}
