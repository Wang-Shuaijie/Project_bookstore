package com.wsj.Bean;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ShopCart implements IShopCart{
	/*
	 * orderlines存储加入到购物车中的产品，key为产品id，value为订单项（订单项中存在数量）
	 * 注意：购物车中产品登陆之后添加，下次在登陆的时候购物车中没有内容
	 * 购物车存储在session会回，每一个用户登陆到服务器，服务器都会为
	 * 每一个客户端分配一个session对象，session的有效时间30分钟
	 */
	private Map<Long,Orderline> orderlines = new HashMap<Long,Orderline>();
	@Override
	public void addProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		int number=1;
		long id=product.getId();
		if(orderlines.containsKey(id)){
			Orderline orderline = (Orderline) orderlines.get(id);
			number = orderline.getNum()+1;
			orderline.setNum(new Integer(number));
		}else{
			Orderline orderline=new Orderline();
			orderline.setNum(new Integer(number));
			orderline.setProduct(product);
			orderlines.put(id, orderline);
		}
		
	}

	@Override
	public void removeProduct(long productid) throws Exception {
		// TODO Auto-generated method stub
		orderlines.remove(productid);
	}

	@Override
	public void removeAllProducts() throws Exception {
		// TODO Auto-generated method stub
		orderlines.clear();
	}

	@Override
	public void updateProduct(long productid, Integer number) throws Exception {
		// TODO Auto-generated method stub
		Orderline orderline=orderlines.get(productid);
		orderline.setNum(number);
	}

	@Override
	public BigDecimal getTotalPrice() throws Exception {
		// TODO Auto-generated method stub
		BigDecimal totalPrice=new BigDecimal(0);
		Iterator<Orderline> iter=getOrderlines();
		while (iter.hasNext()) {
			Orderline o=iter.next();
			Product p=o.getProduct();
			BigDecimal sum=new BigDecimal(p.getPrice()*o.getNum());
			totalPrice=totalPrice.add(sum);
		}
		return totalPrice;
	}

	@Override
	public Iterator<Orderline> getOrderlines() throws Exception {
		// TODO Auto-generated method stub
		return orderlines.values().iterator();
	}
	
	public int getShopCartSize() {
		// TODO Auto-generated method stub
		return orderlines.size();
	}

}
