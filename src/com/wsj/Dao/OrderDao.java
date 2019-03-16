package com.wsj.Dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.criteria.Order;

import com.wsj.Bean.Orders;



public interface OrderDao {
	   //����һ������
		void saveOrder(Orders order);
		
		//ɾ��һ������
		void deleteOrderById(long orderid);
		
		Set<Orders> findOrderByUserid(String userid);

}
