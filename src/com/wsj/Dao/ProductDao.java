package com.wsj.Dao;

import java.util.List;
import java.util.Map;

import com.wsj.Bean.Payway;
import com.wsj.Bean.Product;



public interface ProductDao {
	    //��ѯ���в�Ʒ
	    Map<Long, Product> selectAllProduct();
		
	    List<Payway> SelectAllPayway();

}
