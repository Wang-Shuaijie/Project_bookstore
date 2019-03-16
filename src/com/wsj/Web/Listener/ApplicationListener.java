package com.wsj.Web.Listener;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.wsj.Bean.Product;
import com.wsj.Service.ProductService;
import com.wsj.Service.ProductServiceImpl;


//@WebListener tomcat7.0+����ʹ��
public class ApplicationListener implements ServletContextListener {
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }
    public void contextInitialized(ServletContextEvent arg0)  { 
    	//��ѯ�������еĲ�Ʒ
    	ProductService service=new ProductServiceImpl();
    	Map<Long, Product> products=service.findAllProduct();
    	for(Product p:products.values()){
    		System.out.println(p);
    	}
    	//��ȡapplication����
    	ServletContext application=arg0.getServletContext();
    	//�Ѳ�ѯ�����ж���洢��application������ȥ
    	application.setAttribute("products", products);
    }
}
