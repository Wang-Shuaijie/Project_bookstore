package com.wsj.Bean;

import java.util.Set;

public class Orders {
	private long id;
	private Userinfo user;//用户id
	private Payway payway;//支付id
	private String name;
	private Orderstatus orderstatus;//订单状态id
	private double cost;
	private Set<Orderline> orderlines;//订单项
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Userinfo getUser() {
		return user;
	}
	public void setUser(Userinfo user) {
		this.user = user;
	}
	public Payway getPayway() {
		return payway;
	}
	public void setPayway(Payway payway) {
		this.payway = payway;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Orderstatus getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(Orderstatus orderstatus) {
		this.orderstatus = orderstatus;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public Set<Orderline> getOrderlines() {
		return orderlines;
	}
	public void setOrderlines(Set<Orderline> orderlines) {
		this.orderlines = orderlines;
	}
	
	
}
