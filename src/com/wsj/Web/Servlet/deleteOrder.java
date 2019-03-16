package com.wsj.Web.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wsj.Bean.Orders;
import com.wsj.Bean.Userinfo;
import com.wsj.Service.OrderService;
import com.wsj.Service.OrderServiceImpl;

public class deleteOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String orderid=request.getParameter("orderid");
		OrderService service=new OrderServiceImpl();
		service.deleteOrderByOrderId(Long.parseLong(orderid));
		HttpSession session=request.getSession();
		Userinfo user=(Userinfo) session.getAttribute("user");
		Set<Orders> orders=user.getOrders();
		for(Orders o:orders){
			if(o.getId()==Long.parseLong(orderid)){
				orders.remove(o);
			}
		}
		request.getRequestDispatcher("/user/order.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
