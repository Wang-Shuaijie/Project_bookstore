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
 * ����ÿһ���ԣ�user��ͷ�������������user��ͷ�������ж��û��Ƿ��Ѿ���½��
 * ����û��Ѿ���½�ˣ�ԭ��������ʲô��Դ��������ʲô��Դ�����û�е�½
 * ֱ����ת����½ҳ��
 */
//@WebFilter("/user/*")
public class LoginFilter implements Filter {
	public void destroy() {
		// TODO Auto-generated method stub
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//�ж��û��Ƿ��½
		HttpServletRequest req=(HttpServletRequest) request;
		HttpSession session=req.getSession();
		Userinfo user=(Userinfo) session.getAttribute("user");
		if(user!=null){
			//�û��Ѿ���½����ԭ��������ʲô��Դ��������ʲô��Դ
			chain.doFilter(request, response);
		}else{
			//�û������ڣ�û�е�½
			req.setAttribute("msg", "��!�㻹û��½");
			req.getRequestDispatcher("/login.jsp").forward(req, response);
		}
		
	}
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
