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
		//获取选中的门类代码
		String mlId=req.getParameter("mlId");
		//从数据库中获取对应门类的学科数据列表
		List<XueKe> list1=new ArrayList<XueKe>();
		XueKe xk=new XueKe(0,"--请选择--",-1);
		list1.add(xk);
		List<XueKe> list=xkdao.getAllXKList(mlId);
		for(XueKe x:list) {
			list1.add(x);
		}
		 //json格式的字符串
        Gson gson=new Gson();
        String xkJsonString=gson.toJson(list1);
        resp.getWriter().write(xkJsonString);
	}
}
