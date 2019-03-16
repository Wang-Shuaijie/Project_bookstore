package com.wsj.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.criteria.Order;

import com.wsj.Bean.Category;
import com.wsj.Bean.Orderline;
import com.wsj.Bean.Orders;
import com.wsj.Bean.Orderstatus;
import com.wsj.Bean.Payway;
import com.wsj.Bean.Product;
import com.wsj.Bean.Publish;
import com.wsj.Util.ConnectionFactory;

public class OrderDaoImpl implements OrderDao{

	@Override
	public void saveOrder(Orders order) {
		// TODO Auto-generated method stub
		Connection conn=ConnectionFactory.getConn();
		String sql2="select order_seq.nextval from dual";
		String sql="insert into orders values(?,?,?,?,?,?)";
		String sql1="insert into orderline values(order_seq.nextval,?,?,?)";
		PreparedStatement ps2=null;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		long userid=0;
		
		try {
			ps2=conn.prepareStatement(sql2);
			ResultSet rs=ps2.executeQuery();
			while(rs.next()) {
				userid=rs.getLong(1);
			}
			ps=conn.prepareStatement(sql);
			ps.setLong(1, userid);
			ps.setString(2, order.getUser().getUserid());
			ps.setLong(3, order.getPayway().getId());
			ps.setString(4, order.getName());
			ps.setLong(5, order.getOrderstatus().getId());
			ps.setDouble(6, order.getCost());
			ps.execute();
			ps1=conn.prepareStatement(sql1);
			Set<Orderline> orderlines=order.getOrderlines();
			for(Orderline line:orderlines){
				ps1.setLong(1, userid);
				ps1.setLong(2, line.getProduct().getId());
				ps1.setInt(3, line.getNum());
				ps1.execute();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOrderById(long orderid) {
		// TODO Auto-generated method stub
		Connection conn=ConnectionFactory.getConn();
		Statement sts=null;
		try {
			sts=conn.createStatement();
			String sql1="delete from orderline where order_id="+orderid;
			sts.execute(sql1);
			String sql="delete from orders where id="+orderid;
			sts.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Set<Orders> findOrderByUserid(String userid) {
		// TODO Auto-generated method stub
		Connection conn=ConnectionFactory.getConn();
		Statement sts=null;
		ResultSet rs=null;
		Set<Orders> set=new HashSet<Orders>();
		try {
			sts=conn.createStatement();
			String sql="select o.id,o.name,o.cost,p.id,p.name,s.id,s.name,s.description,r.id,r.num,d.id,d.name,d.writer,d.price,d.page,d.description,d.images,u.id,u.name,c.id,c.name,c.description"
					+ "  from orders o,payway p,orderstatus s,orderline r,product d,publish u,category c"
					+ "  where o.user_id='"+userid +"' and o.payway_id=p.id and o.orderstatus_id=s.id and r.order_id=o.id and r.product_id=d.id and d.publish_id=u.id and d.category_id=c.id";
			rs=sts.executeQuery(sql);
			Map<Long, Orders> map=new HashMap<Long, Orders>();
			while(rs.next()){
				Long id=rs.getLong(1);
				if(!map.containsKey(id)){
					Orders order=new Orders();
					order.setId(id);
					order.setName(rs.getString(2));
					order.setCost(rs.getDouble(3));
					Payway pay=new Payway();
					pay.setId(rs.getLong(4));
					pay.setName(rs.getString(5));
					order.setPayway(pay);
					Orderstatus status=new Orderstatus();
					status.setId(rs.getLong(6));
					status.setName(rs.getString(7));
					status.setDescription(rs.getString(8));
					order.setOrderstatus(status);
					Set<Orderline> orderlines=new HashSet<Orderline>();
					Orderline line=new Orderline();
					line.setId(rs.getLong(9));
					line.setNum(rs.getInt(10));
					Product p=new Product();
					p.setId(rs.getLong(11));
					p.setName(rs.getString(12));
					p.setWriter(rs.getString(13));
					p.setPrice(rs.getDouble(14));
					p.setPage(rs.getLong(15));
					p.setDescription(rs.getString(16));
					p.setImages(rs.getString(17));
					Publish publish=new Publish();
					publish.setId(rs.getLong(18));
					publish.setName(rs.getString(19));
					p.setPublish(publish);
					Category cate=new Category();
					cate.setId(rs.getLong(20));
					cate.setName(rs.getString(21));
					cate.setDescription(rs.getString(22));
					p.setPublish(publish);
					p.setCategory(cate);
					line.setProduct(p);
					line.setOrder(order);
					orderlines.add(line);
					order.setOrderlines(orderlines);
					map.put(id, order);
				}else{
					Orders order=map.get(id);
					Orderline line=new Orderline();
					line.setId(rs.getLong(9));
					line.setNum(rs.getInt(10));
					Product p=new Product();
					p.setId(rs.getLong(11));
					p.setName(rs.getString(12));
					p.setWriter(rs.getString(13));
					p.setPrice(rs.getDouble(14));
					p.setPage(rs.getLong(15));
					p.setDescription(rs.getString(16));
					p.setImages(rs.getString(17));
					Publish publish=new Publish();
					publish.setId(rs.getLong(18));
					publish.setName(rs.getString(19));
					p.setPublish(publish);
					Category cate=new Category();
					cate.setId(rs.getLong(20));
					cate.setName(rs.getString(21));
					cate.setDescription(rs.getString(22));
					p.setCategory(cate);
					line.setProduct(p);
					line.setOrder(order);
					order.getOrderlines().add(line);
					map.put(id, order);
				}
			}
			if(map!=null){
				for(Orders m:map.values()){
					set.add(m);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return set;
	}

}
