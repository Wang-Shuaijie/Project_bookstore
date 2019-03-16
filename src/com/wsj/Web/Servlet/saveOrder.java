package com.wsj.Web.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wsj.Bean.Orderline;
import com.wsj.Bean.Orders;
import com.wsj.Bean.Orderstatus;
import com.wsj.Bean.Payway;
import com.wsj.Bean.ShopCart;
import com.wsj.Bean.Userinfo;
import com.wsj.Service.OrderService;
import com.wsj.Service.OrderServiceImpl;

public class saveOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paywayid=request.getParameter("payway");
		HttpSession session=request.getSession();
		Userinfo user=(Userinfo) session.getAttribute("user");
		ShopCart cart=(ShopCart) session.getAttribute("cart");
		ServletContext application=request.getServletContext();
		List<Payway> pays=(List<Payway>) application.getAttribute("pays");
		Payway pay=null;
		for(Payway p:pays){
			if(p.getId()==Long.parseLong(paywayid)){
				pay=p;
			}
		}
		try {
			if(cart.getShopCartSize()>=1){
				Orders order=new Orders();
				order.setUser(user);
				order.setCost(cart.getTotalPrice().doubleValue());
				order.setName("杰普");
				order.setPayway(pay);
				Orderstatus status=new Orderstatus();
				status.setId(1);
				status.setName("等待处理");
				status.setDescription("等待处理");
				order.setOrderstatus(status);
				Set<Orderline> orderlines=new HashSet<Orderline>();
				Iterator<Orderline> iter=cart.getOrderlines();
				while(iter.hasNext()){
					orderlines.add(iter.next());
				}
				order.setOrderlines(orderlines);
				OrderService service=new OrderServiceImpl();
				service.saveOrder(order);
				cart.removeAllProducts();
				request.setAttribute("order", order);
				request.getRequestDispatcher("/user/orderinfo.jsp").forward(request, response);
			}else{
				request.setAttribute("msg", "亲，请选择商品");
				request.getRequestDispatcher("/user/index.jsp").forward(request, response);
			}
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