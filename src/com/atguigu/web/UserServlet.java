package com.atguigu.web;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.util.WebUtils;
import com.google.gson.Gson;
public class UserServlet extends BaseServlet{
	private UserService userServlet=new UserServiceImpl();
	/**
	 * ע��
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//����Session���û���¼����Ϣ
		req.getSession().invalidate();
		//�ض�����ҳ(���¼ҳ)
		resp.sendRedirect(req.getContextPath()+"/DDL.jsp");
	}
	
	
	
	/**
	 * �����¼����
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		   //1.��ȡ�������
			User user=WebUtils.copyParamToBean(req.getParameterMap(), new User());
			String username=user.getUsername();
			String password=user.getPassword();
			if(userServlet.loginUser(user)==null) {
				//�Ѵ�����Ϣ���ͻ��Եı�����Ϣ�����浽Request����
				req.setAttribute("username", username);//�����û���
				req.setAttribute("msg", "�û������������");
				//���ص�¼ҳ��
				req.getRequestDispatcher("NewLogin.jsp").forward(req, resp);
			}else {//���ص�¼�ɹ�ҳ��	
				Cookie cookie=new Cookie("username",username);
				cookie.setMaxAge(60*60*24*7);//��ǰcookieһ������Ч
				//�����û���Ϣ��Session��
				req.getSession().setAttribute("user", user);
				Object userString=req.getSession().getAttribute("user");
				System.out.println(userString.toString());
				resp.addCookie(cookie);
				req.getRequestDispatcher("DDL.jsp").forward(req, resp);
			}

	}
	
	/**
	 * ����ע������
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		User user=WebUtils.copyParamToBean(req.getParameterMap(), new User());
		//��ȡSession�е���֤��
		String token=(String)req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
		//ɾ��Session�е���֤��
		req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
		//1.��ȡ�������
		String username=user.getUsername();
		String password=user.getPassword();
		String email=user.getEmail();
		String code=req.getParameter("code");
		
		
		//2.�����֤���Ƿ���ȷ
		if(token!=null) {//Session�е���֤�벻Ϊ��
			if(token.equalsIgnoreCase(code)) {//��֤����ȷ
				//3.����û����Ƿ��Ѵ���
				if(userServlet.existsUserName(username)) {
					System.out.println("�û���["+username+"]�Ѵ���");
					//�Ѵ�����Ϣ���ͻ��Եı�����Ϣ�����浽Request����
					req.setAttribute("username", username);//�����û���
					req.setAttribute("email", email);//�����û���
					req.setAttribute("msg", "�û����Ѵ���");
					//����ע��ҳ��
					req.getRequestDispatcher("NewRegister.jsp").forward(req, resp);
					
				}else {
					userServlet.registUser(user);
					req.setAttribute("msg", "ע��ɹ�");
					//����ע��ɹ�ҳ��
					//req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
					req.getRequestDispatcher("NewRegister.jsp").forward(req, resp);
				}
			}else {//��֤�벻��ȷ
				System.out.println("��֤��["+code+"]����ȷ");
				//�Ѵ�����Ϣ���ͻ��Եı�����Ϣ�����浽Request����
				req.setAttribute("username", username);//�����û���
				req.setAttribute("email", email);//�����û���
				req.setAttribute("msg", "��֤������");
				//����ע��ҳ��
				req.getRequestDispatcher("NewRegister.jsp").forward(req, resp);
			}
			
		}else {//Session�е���֤��Ϊ��,֤�����ظ��ύ��
			req.setAttribute("msg", "�����ظ�ע��");
			//����ע��ҳ��
			req.getRequestDispatcher("NewRegister.jsp").forward(req, resp);
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

}
