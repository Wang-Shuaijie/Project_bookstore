package com.wsj.Service;

import java.util.List;
import java.util.Map;

import com.wsj.Bean.Payway;
import com.wsj.Bean.Product;

public interface ProductService {
	//��ѯ�������еĲ�Ʒ��map��keyΪ��Ʒ��id��map��ֵΪ��Ʒ
	Map<Long, Product> findAllProduct();
	List<Payway> findAllPayway();
}	

