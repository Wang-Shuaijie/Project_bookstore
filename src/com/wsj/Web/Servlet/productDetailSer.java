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
		//��ȡapplication����
		ServletContext application=request.getServletContext();
		//��ȡ���еĲ�Ʒ
		Map<Long, Product> products=(Map<Long, Product>) application.getAttribute("products");
		//����id��������ȡ����Ӧ�Ĳ�Ʒ
		Product pro=products.get(Long.parseLong(id));
		//�Ѳ�Ʒ������������ת�Ĳ�Ʒ��ϸ��ҳ��
		request.setAttribute("product", pro);
		request.getRequestDispatcher("/productDetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
