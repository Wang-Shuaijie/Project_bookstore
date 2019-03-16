package com.wsj.Web.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wsj.Bean.Userinfo;
import com.wsj.Service.UserService;
import com.wsj.Service.UserServiceImpl;
import com.wsj.Util.UserServiceException;

public class registerSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接受浏览器传过来的数据,接受到的数据一定是String类型
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		String country=request.getParameter("country");
		String province=request.getParameter("province");
		String city=request.getParameter("city");
		String street1=request.getParameter("street1");
		String street2=request.getParameter("street2");
		String zip=request.getParameter("zip");
		String homephone=request.getParameter("homephone");
		String officephone=request.getParameter("officephone");
		String cellphone=request.getParameter("cellphone");
		String email=request.getParameter("email");
		Userinfo user=new Userinfo();
		user.setUserid(userid);
		user.setPassword(password);
		user.setCountry(country);
		user.setProvince(province);
		user.setCity(city);
		user.setStreet1(street1);
		user.setStreet2(street2);
		user.setZip(zip);
		user.setCellphone(cellphone);
		user.setHomephone(homephone);
		user.setOfficephone(officephone);
		user.setEmail(email);
		UserService service=new UserServiceImpl();
		try {
			service.registerUser(user);
			request.setAttribute("msg", "注册成功");
			//注册成功，直接跳转到注册页面
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} catch (UserServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//将注册service层中报错信息发给前台register.jsp页面
			request.setAttribute("msg", e.getMessage());
			//注册失败
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
