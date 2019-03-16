package com.wsj.Service;

import java.util.List;
import java.util.Map;

import com.wsj.Bean.Payway;
import com.wsj.Bean.Product;
import com.wsj.Dao.ProductDao;
import com.wsj.Dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService{
	private ProductDao dao=new ProductDaoImpl();
	@Override
	public Map<Long, Product> findAllProduct() {
		// TODO Auto-generated method stub
		Map<Long, Product> pro=dao.selectAllProduct();
		return pro;
	}
	@Override
	public List<Payway> findAllPayway() {
		// TODO Auto-generated method stub
		List<Payway> list= dao.SelectAllPayway();
		return list;
	}

}