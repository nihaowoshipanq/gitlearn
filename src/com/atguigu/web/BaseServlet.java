package com.atguigu.web;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ���post����������������
        // һ��Ҫ�ڻ�ȡ�������֮ǰ���ò���Ч
        req.setCharacterEncoding("UTF-8");
        // �����Ӧ������������
        resp.setContentType("text/html; charset=UTF-8");
		//��ȡ����ֵaction
		String action = req.getParameter("action"); 
		try {
			// ��ȡ action ҵ������ַ�������ȡ��Ӧ��ҵ�� �����������
			 Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
			// ����Ŀ��ҵ�� ����
			 method.invoke(this, req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);// ���쳣�׸� Filter ������
		} 
		
	}

}
