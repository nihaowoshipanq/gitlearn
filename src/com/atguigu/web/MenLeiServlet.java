package com.atguigu.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.dao.MenLeiDao;
import com.atguigu.dao.impl.MenLeiDaoImpl;
import com.atguigu.pojo.MenLei;
import com.atguigu.util.WebUtils;
import com.google.gson.Gson;

public class MenLeiServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;
	MenLeiDao mldao=new MenLeiDaoImpl(); 
	protected void getMLList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//�����ݿ��л�ȡ����������б�
		List<MenLei> list=mldao.getAllMLList();
		 //json��ʽ���ַ���
        Gson gson=new Gson();
        String mlJsonString=gson.toJson(list);
        resp.getWriter().write(mlJsonString);
	}

}
