package com.wsj.Bean;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ShopCart implements IShopCart{
	/*
	 * orderlines�洢���뵽���ﳵ�еĲ�Ʒ��keyΪ��Ʒid��valueΪ������������д���������
	 * ע�⣺���ﳵ�в�Ʒ��½֮����ӣ��´��ڵ�½��ʱ���ﳵ��û������
	 * ���ﳵ�洢��session��أ�ÿһ���û���½��������������������Ϊ
	 * ÿһ���ͻ��˷���һ��session����session����Чʱ��30����
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
