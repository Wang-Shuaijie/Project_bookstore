package com.wsj.Web.Listener;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.wsj.Bean.Product;
import com.wsj.Service.ProductService;
import com.wsj.Service.ProductServiceImpl;


//@WebListener tomcat7.0+可以使用
public class ApplicationListener implements ServletContextListener {
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }
    public void contextInitialized(ServletContextEvent arg0)  { 
    	//查询出来所有的产品
    	ProductService service=new ProductServiceImpl();
    	Map<Long, Product> products=service.findAllProduct();
    	for(Product p:products.values()){
    		System.out.println(p);
    	}
    	//获取application对象
    	ServletContext application=arg0.getServletContext();
    	//把查询的所有对象存储到application容器中去
    	application.setAttribute("products", products);
    }
}
