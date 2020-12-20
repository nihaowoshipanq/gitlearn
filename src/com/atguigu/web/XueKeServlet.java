package com.atguigu.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.dao.XueKeDao;
import com.atguigu.dao.impl.XueKeDaoMImpl;
import com.atguigu.pojo.XueKe;
import com.atguigu.util.WebUtils;
import com.google.gson.Gson;

public class XueKeServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	XueKeDao xkdao=new XueKeDaoMImpl() ;
		
	protected void getXKList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡѡ�е��������
		String mlId=req.getParameter("mlId");
		//�����ݿ��л�ȡ��Ӧ�����ѧ�������б�
		List<XueKe> list1=new ArrayList<XueKe>();
		XueKe xk=new XueKe(0,"--��ѡ��--",-1);
		list1.add(xk);
		List<XueKe> list=xkdao.getAllXKList(mlId);
		for(XueKe x:list) {
			list1.add(x);
		}
		 //json��ʽ���ַ���
        Gson gson=new Gson();
        String xkJsonString=gson.toJson(list1);
        resp.getWriter().write(xkJsonString);
	}
}
