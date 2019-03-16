package com.wsj.Dao;

import java.util.List;
import java.util.Map;

import com.wsj.Bean.Payway;
import com.wsj.Bean.Product;



public interface ProductDao {
	    //查询所有产品
	    Map<Long, Product> selectAllProduct();
		
	    List<Payway> SelectAllPayway();

}
