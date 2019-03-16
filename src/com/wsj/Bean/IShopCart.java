package com.wsj.Bean;

import java.math.BigDecimal;
import java.util.Iterator;

public interface IShopCart {
	//增加产品进购物车
	void addProduct(Product product) throws Exception;
	//移除产品
	void removeProduct(long productid)throws Exception;
	//移除全部产品
	void removeAllProducts()throws Exception;
	//更新产品
	void updateProduct(long productid, Integer number)throws Exception;
	//总价钱
	BigDecimal getTotalPrice()throws Exception;
	//显示购物车里的产品
	Iterator<Orderline> getOrderlines()throws Exception;
}
