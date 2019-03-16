package com.wsj.Web.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wsj.Bean.Product;
import com.wsj.Bean.ShopCart;

public class addProductSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		ServletContext application=request.getServletContext();
		Map<Long, Product> products=(Map<Long, Product>) application.getAttribute("products");
		Product pro=products.get(Long.parseLong(id));
		HttpSession session=request.getSession();
		//��ȡ���ﳵ
		ShopCart cart=(ShopCart) session.getAttribute("cart");
		try {
			//�Ѳ�Ʒ��ӵ����ﳵ��
			cart.addProduct(pro);
			//��������Ʒ�Ĺ��ﳵ����ֲ�뵽session������ȥ
			session.setAttribute("cart", cart);
			//��ת����ҳ��
			request.setAttribute("msg", "��ӳɹ�");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}
