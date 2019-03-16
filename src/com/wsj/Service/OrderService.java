package com.wsj.Service;

import java.util.Set;

import com.wsj.Bean.Orders;

public interface OrderService {
	void saveOrder(Orders order);
	Set<Orders> getAllOrders(String userid);
	void deleteOrderByOrderId(long orderid);
}
