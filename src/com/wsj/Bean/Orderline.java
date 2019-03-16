package com.wsj.Bean;

import java.util.Set;

public class Orderline {
	private long id;
	private Orders order; //¶©µ¥id
	private Product product; //²úÆ·id
	private int num;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
}
