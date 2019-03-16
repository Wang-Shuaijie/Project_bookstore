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
			//��½�ɹ�֮���û���Ϣ����session�У�session������ÿ���û�˽�еģ��û�ͨ����������ʷ�������ʱ��
			//���������ÿһ�����������һ��session����,session�������û��������÷�����ʱ�䳬��30���ӣ��Զ����٣�
			//��session�����Ǳ�����jspҳ�湲���
			//��ȡsession����
			HttpSession session=request.getSession();
			session.setAttribute("user", u);
			session.setAttribute("cart", new ShopCart());
			//request���������ڣ�ʼ���������ֹ������������ԣ�ÿһ�������������������һ��ȫ�µ�request��response
			request.setAttribute("msg", "��½�ɹ�");
			//��½�ɹ���ת����ҳ��
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (UserServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//��½���ɹ������
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
