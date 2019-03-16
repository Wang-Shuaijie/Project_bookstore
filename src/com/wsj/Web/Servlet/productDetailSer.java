package com.wsj.Web.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wsj.Bean.Product;

public class productDetailSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		//获取application容器
		ServletContext application=request.getServletContext();
		//获取所有的产品
		Map<Long, Product> products=(Map<Long, Product>) application.getAttribute("products");
		//基于id从容器中取出对应的产品
		Product pro=products.get(Long.parseLong(id));
		//把产品传给接下来跳转的产品详细的页面
		request.setAttribute("product", pro);
		request.getRequestDispatcher("/productDetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
