package com.atguigu.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.dao.resultDao;
import com.atguigu.dao.impl.resultDaoImpl;
import com.atguigu.pojo.XueKe;
import com.atguigu.pojo.result;
import com.atguigu.util.WebUtils;
import com.google.gson.Gson;

public class resultServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;
	resultDao result=new resultDaoImpl() ;
		
	protected void getreList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡѡ�е����ࡢѧ�ơ�רҵ����
		String province=req.getParameter("province");
		String mlId=req.getParameter("mlname");//����
		String xkIdString=req.getParameter("xkname");//ѧ��
		String zynameString=req.getParameter("zyname");//רҵ
		System.out.println(province);
		//�����ݿ��л�ȡ��Ӧ�����ѧ�������б�
		//List<result> list1=new ArrayList<result>();
		//result xk=new result(0,"--��ѡ��--",-1);
//		list1.add(xk);
		String findsql=null;
		if(zynameString.equals("0")&province.equals("0")) {
			findsql="where a.mlid="+mlId+" and a.xkid="+xkIdString+";";
		}else {
			if(zynameString.equals("0"))
				findsql="where a.mlid="+mlId+" and a.xkid="+xkIdString+" and a.province='"+province+"';";
			if(province.equals("0"))
				findsql="where a.mlid="+mlId+" and a.xkid="+xkIdString+" and a.mjid="+zynameString+";";
			if(!zynameString.equals("0")&!province.equals("0"))
				findsql="where a.mlid="+mlId+" and a.xkid="+xkIdString+" and a.mjid="+zynameString+" and a.province='"+province+"';";
		}

		System.out.println(findsql);
		
		//System.out.println(findsql);
		List<result> list=result.getResult(findsql);
//		for(XueKe x:list) {
//			list1.add(x);
//		}
		 //json��ʽ���ַ���
        Gson gson=new Gson();
        String xkJsonString=gson.toJson(list);
        resp.getWriter().write(xkJsonString);
	}

}
