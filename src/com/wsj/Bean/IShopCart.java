package com.wsj.Bean;

import java.math.BigDecimal;
import java.util.Iterator;

public interface IShopCart {
	//���Ӳ�Ʒ�����ﳵ
	void addProduct(Product product) throws Exception;
	//�Ƴ���Ʒ
	void removeProduct(long productid)throws Exception;
	//�Ƴ�ȫ����Ʒ
	void removeAllProducts()throws Exception;
	//���²�Ʒ
	void updateProduct(long productid, Integer number)throws Exception;
	//�ܼ�Ǯ
	BigDecimal getTotalPrice()throws Exception;
	//��ʾ���ﳵ��Ĳ�Ʒ
	Iterator<Orderline> getOrderlines()throws Exception;
}
