package com.wsj.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wsj.Bean.Category;
import com.wsj.Bean.Payway;
import com.wsj.Bean.Product;
import com.wsj.Bean.Publish;
import com.wsj.Util.ConnectionFactory;

public class ProductDaoImpl implements ProductDao{

	@Override
	public Map<Long, Product> selectAllProduct() {
		// TODO Auto-generated method stub
		Connection conn=ConnectionFactory.getConn();
		String sql="select p.id,p.name,p.writer,p.price,p.description,p.images,p.page,u.id,u.name,c.id,c.name,c.description  "
				+ " from product p,publish u,category c"
				+ " where p.publish_id=u.id and p.category_id=c.id ";
		ResultSet rs=null;
		Map<Long, Product> pros=new HashMap<Long, Product>();
		try {
			Statement sts=conn.createStatement();
			rs=sts.executeQuery(sql);
			while(rs.next()){
				Product pro=new Product();
				long id=rs.getLong(1);
				pro.setId(id);
				pro.setName(rs.getString(2));
				pro.setWriter(rs.getString(3));
				pro.setPrice(rs.getDouble(4));
				pro.setDescription(rs.getString(5));
				pro.setImages(rs.getString(6));
				pro.setPage(rs.getLong(7));
				Publish pu=new Publish();
				pu.setId(rs.getLong(8));
				pu.setName(rs.getString(9));
				Category c=new Category();
				c.setId(rs.getLong(10));
				c.setName(rs.getString(11));
				c.setDescription(rs.getString(12));
				pro.setPublish(pu);
				pro.setCategory(c);
				pros.put(id, pro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pros;
	}

	@Override
	public List<Payway> SelectAllPayway() {
		// TODO Auto-generated method stub
		Connection conn=ConnectionFactory.getConn();
		Statement sts=null;
		ResultSet rs=null;
		List<Payway> pays=new ArrayList<Payway>();
		try {
			sts=conn.createStatement();
			String sql="select id,name from payway";
			rs=sts.executeQuery(sql);
			while(rs.next()){
				long id=rs.getLong(1);
				String name=rs.getString(2);
				Payway pay=new Payway();
				pay.setId(id);
				pay.setName(name);
				pays.add(pay);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pays;
	}

	

}
