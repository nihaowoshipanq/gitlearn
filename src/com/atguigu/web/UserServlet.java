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
	 * 注销
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//销毁Session中用户登录的信息
		req.getSession().invalidate();
		//重定向到首页(或登录页)
		resp.sendRedirect(req.getContextPath()+"/DDL.jsp");
	}
	
	
	
	/**
	 * 处理登录事务
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		   //1.获取请求参数
			User user=WebUtils.copyParamToBean(req.getParameterMap(), new User());
			String username=user.getUsername();
			String password=user.getPassword();
			if(userServlet.loginUser(user)==null) {
				//把错误信息、和回显的表单项信息，保存到Request域中
				req.setAttribute("username", username);//回显用户名
				req.setAttribute("msg", "用户名或密码错误");
				//跳回登录页面
				req.getRequestDispatcher("NewLogin.jsp").forward(req, resp);
			}else {//跳回登录成功页面	
				Cookie cookie=new Cookie("username",username);
				cookie.setMaxAge(60*60*24*7);//当前cookie一周内有效
				//保存用户信息到Session中
				req.getSession().setAttribute("user", user);
				Object userString=req.getSession().getAttribute("user");
				System.out.println(userString.toString());
				resp.addCookie(cookie);
				req.getRequestDispatcher("DDL.jsp").forward(req, resp);
			}

	}
	
	/**
	 * 处理注册事务
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		User user=WebUtils.copyParamToBean(req.getParameterMap(), new User());
		//获取Session中的验证码
		String token=(String)req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
		//删除Session中的验证码
		req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
		//1.获取请求参数
		String username=user.getUsername();
		String password=user.getPassword();
		String email=user.getEmail();
		String code=req.getParameter("code");
		
		
		//2.检查验证码是否正确
		if(token!=null) {//Session中的验证码不为空
			if(token.equalsIgnoreCase(code)) {//验证码正确
				//3.检查用户名是否已存在
				if(userServlet.existsUserName(username)) {
					System.out.println("用户名["+username+"]已存在");
					//把错误信息、和回显的表单项信息，保存到Request域中
					req.setAttribute("username", username);//回显用户名
					req.setAttribute("email", email);//回显用户名
					req.setAttribute("msg", "用户名已存在");
					//跳回注册页面
					req.getRequestDispatcher("NewRegister.jsp").forward(req, resp);
					
				}else {
					userServlet.registUser(user);
					req.setAttribute("msg", "注册成功");
					//跳回注册成功页面
					//req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
					req.getRequestDispatcher("NewRegister.jsp").forward(req, resp);
				}
			}else {//验证码不正确
				System.out.println("验证码["+code+"]不正确");
				//把错误信息、和回显的表单项信息，保存到Request域中
				req.setAttribute("username", username);//回显用户名
				req.setAttribute("email", email);//回显用户名
				req.setAttribute("msg", "验证码有误");
				//跳回注册页面
				req.getRequestDispatcher("NewRegister.jsp").forward(req, resp);
			}
			
		}else {//Session中的验证码为空,证明表单重复提交了
			req.setAttribute("msg", "请勿重复注册");
			//跳回注册页面
			req.getRequestDispatcher("NewRegister.jsp").forward(req, resp);
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

}
