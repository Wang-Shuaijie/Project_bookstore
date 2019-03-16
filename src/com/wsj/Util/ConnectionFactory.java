package com.wsj.Util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	public static Connection getConn(){
		Connection conn=null;
		try {
			Properties pro=new Properties();
			InputStream is=ConnectionFactory.class.getResourceAsStream("../../../db.properties");
			pro.load(is);
			Class.forName(pro.getProperty("driver"));
			conn=DriverManager.getConnection(pro.getProperty("url"), pro.getProperty("username"), pro.getProperty("password"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
