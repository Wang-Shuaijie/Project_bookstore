package com.wsj.Web.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.wsj.Bean.Userinfo;

/**
 * 过滤每一个以／user开头的请求，如果是以user开头的请求，判断用户是否已经登陆。
 * 如果用户已经登陆了，原来该请求什么资源还是请求什么资源，如果没有登陆
 * 直接跳转到登陆页面
 */
//@WebFilter("/user/*")
public class LoginFilter implements Filter {
	public void destroy() {
		// TODO Auto-generated method stub
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//判断用户是否登陆
		HttpServletRequest req=(HttpServletRequest) request;
		HttpSession session=req.getSession();
		Userinfo user=(Userinfo) session.getAttribute("user");
		if(user!=null){
			//用户已经登陆过，原来该请求什么资源接着请求什么资源
			chain.doFilter(request, response);
		}else{
			//用户不存在，没有登陆
			req.setAttribute("msg", "亲!你还没登陆");
			req.getRequestDispatcher("/login.jsp").forward(req, response);
		}
		
	}
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
