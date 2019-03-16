package com.wsj.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wsj.Bean.Userinfo;
import com.wsj.Util.ConnectionFactory;



public class UserDaoImpl implements UserDao{

	@Override
	public void saveUser(Userinfo user) {
		// TODO Auto-generated method stub
		Connection con=ConnectionFactory.getConn();
		PreparedStatement ps=null;
		String sql="insert into userinfo values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, user.getUserid());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getCountry());
			ps.setString(4, user.getProvince());
			ps.setString(5, user.getCity());
			ps.setString(6, user.getStreet1());
			ps.setString(7, user.getStreet2());
			ps.setString(8, user.getZip());
			ps.setString(9, user.getHomephone());
			ps.setString(10, user.getOfficephone());
			ps.setString(11, user.getCellphone());
			ps.setString(12, user.getEmail());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Userinfo findUserByUserId(String userid) {
		// TODO Auto-generated method stub
		Connection conn=ConnectionFactory.getConn();
		String sql="select  userid,password,country,province,city,street1,street2,zip,homephone,officephone,cellphone,email from userinfo where userid=?";
		PreparedStatement ps=null;
		ResultSet rs=null;
		Userinfo user=null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, userid);
			rs=ps.executeQuery();
			while(rs.next()){
				user=new Userinfo();
				user.setUserid(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setCountry(rs.getString(3));
				user.setProvince(rs.getString(4));
				user.setCity(rs.getString(5));
				user.setStreet1(rs.getString(6));
				user.setStreet2(rs.getString(7));
				user.setZip(rs.getString(8));
				user.setHomephone(rs.getString(9));
				user.setOfficephone(rs.getString(10));
				user.setCellphone(rs.getString(11));
				user.setEmail(rs.getString(12));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void updateUserByUserId(Userinfo user) {
		// TODO Auto-generated method stub
		Connection conn=ConnectionFactory.getConn();
		String sql="update userinfo set password=?,country=?,province=?,city=?,street1=?,street2=?,zip=?,homephone=?,officephone=?,cellphone=?,email=? where userid=?";
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getCountry());
			ps.setString(3, user.getProvince());
			ps.setString(4, user.getCity());
			ps.setString(5, user.getStreet1());
			ps.setString(6, user.getStreet2());
			ps.setString(7, user.getZip());
			ps.setString(8, user.getHomephone());
			ps.setString(9, user.getOfficephone());
			ps.setString(10, user.getCellphone());
			ps.setString(11, user.getEmail());
			ps.setString(12, user.getUserid());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
