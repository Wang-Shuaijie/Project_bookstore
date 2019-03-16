package com.wsj.Web.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wsj.Bean.ShopCart;
import com.wsj.Bean.Userinfo;
import com.wsj.Service.UserService;
import com.wsj.Service.UserServiceImpl;
import com.wsj.Util.UserServiceException;

public class LoginSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		UserService service=new UserServiceImpl();
		Userinfo u=null;
		try {
			u=service.loginUser(userid, password);
			//登陆成功之后，用户信息存在session中（session对象是每个用户私有的，用户通过浏览器访问服务器的时候
			//服务器会给每一个浏览器构建一个session对象,session对象在用户不操作该服务器时间超过30分钟，自动销毁，
			//）session对象是被所有jsp页面共享的
			//获取session对象
			HttpSession session=request.getSession();
			session.setAttribute("user", u);
			session.setAttribute("cart", new ShopCart());
			//request的生命周期：始于浏览器终止与浏览器，所以，每一次浏览器发出的请求都是一个全新的request和response
			request.setAttribute("msg", "登陆成功");
			//登陆成功跳转到主页面
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (UserServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//登陆不成功的情况
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
