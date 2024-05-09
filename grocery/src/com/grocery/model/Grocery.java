package com.grocery.model;

public class Grocery {

	int id;
	int quantity;
	int amount;
	String product;
	int price;
	int totalamount;

	public Grocery() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(int totalamount) {
		this.totalamount = totalamount;
	}

	public Grocery( int quantity, int amount, String product, int price) {
		super();
		//this.id = id;
		this.quantity = quantity;
		this.amount = amount;
		this.product = product;
		this.price = price;
		//this.totalamount = totalamount;
	}

	@Override
	public String toString() {
		return "Grocery [id=" + id + ", quantity=" + quantity + ", amount=" + amount + ", product=" + product
				+ ", price=" + price + ", totalamount=" + totalamount + "]";
	}

}
