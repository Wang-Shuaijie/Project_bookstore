package com.wsj.Service;

import java.util.Set;

import com.wsj.Bean.Orders;
import com.wsj.Dao.OrderDao;
import com.wsj.Dao.OrderDaoImpl;

public class OrderServiceImpl implements OrderService{
	private OrderDao dao=new OrderDaoImpl();
	@Override
	public void saveOrder(Orders order) {
		// TODO Auto-generated method stub
		dao.saveOrder(order);
	}

	@Override
	public Set<Orders> getAllOrders(String userid) {
		// TODO Auto-generated method stub
		return dao.findOrderByUserid(userid);
	}

	@Override
	public void deleteOrderByOrderId(long orderid) {
		// TODO Auto-generated method stub
		dao.deleteOrderById(orderid);
	}

}
