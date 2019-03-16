package com.wsj.Dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.criteria.Order;

import com.wsj.Bean.Orders;



public interface OrderDao {
	   //保存一个订单
		void saveOrder(Orders order);
		
		//删除一个订单
		void deleteOrderById(long orderid);
		
		Set<Orders> findOrderByUserid(String userid);

}
