package com.wsj.Web.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wsj.Bean.Userinfo;
import com.wsj.Service.UserService;
import com.wsj.Service.UserServiceImpl;
import com.wsj.Util.UserServiceException;

public class modifyUserSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//接受前台传过来用户的参数
				String  password=request.getParameter("password");
				String  country=request.getParameter("country");
				String  province=request.getParameter("province");
				String  city=request.getParameter("city");
				String  street1=request.getParameter("street1");
				String  street2=request.getParameter("street2");
				String  zip=request.getParameter("zip");
				String  homephone=request.getParameter("homephone");
				String  officephone=request.getParameter("officephone");
				String  cellphone=request.getParameter("cellphone");
				String  email=request.getParameter("email");
			HttpSession session=request.getSession();
			Userinfo user=(Userinfo)session.getAttribute("user");
			user.setCellphone(cellphone);
			user.setCity(city);
			user.setCountry(country);
			user.setEmail(email);
			user.setHomephone(homephone);
			user.setOfficephone(officephone);
			user.setPassword(password);
			user.setStreet1(street1);
			user.setProvince(province);
			user.setStreet2(street2);
			user.setZip(zip);
			UserService service=new UserServiceImpl();
			try {
				service.updateUser(user);
				request.getRequestDispatcher("/user/userinfo.jsp").forward(request, response);
			} catch (UserServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
