package com.wsj.Service;

import java.util.List;
import java.util.Map;

import com.wsj.Bean.Payway;
import com.wsj.Bean.Product;

public interface ProductService {
	//查询出来所有的产品，map的key为产品的id，map的值为产品
	Map<Long, Product> findAllProduct();
	List<Payway> findAllPayway();
}	

