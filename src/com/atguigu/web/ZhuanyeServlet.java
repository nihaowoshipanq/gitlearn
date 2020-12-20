package com.atguigu.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.dao.ZhuanyeDao;
import com.atguigu.dao.impl.ZhuanyeDaoImpl;
import com.atguigu.pojo.XueKe;
import com.atguigu.pojo.Zhuanye;
import com.atguigu.util.WebUtils;
import com.google.gson.Gson;

public class ZhuanyeServlet extends BaseServlet{
	ZhuanyeDao zydao=new ZhuanyeDaoImpl();
	protected void getZYList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String zyIdString=req.getParameter("zyId");
		//�����ݿ��л�ȡ��Ӧѧ�Ƶ�רҵ�����б�
		List<Zhuanye> list1=new ArrayList<Zhuanye>();
		Zhuanye zy=new Zhuanye(0,"--��ѡ��--",-1);
		list1.add(zy);
		List<Zhuanye> list=zydao.getAllZYList(zyIdString);
		for(Zhuanye x:list) {
			list1.add(x);
		}
		 //json��ʽ���ַ���
        Gson gson=new Gson();
        String xkJsonString=gson.toJson(list1);
        resp.getWriter().write(xkJsonString);
	}

}
