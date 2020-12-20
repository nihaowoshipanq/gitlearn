package com.atguigu.dao.impl;

import java.util.List;

import com.atguigu.dao.resultDao;
import com.atguigu.pojo.result;

public class resultDaoImpl extends BaseDao implements resultDao{
//	public static void main(String[] args) {
//		String mlId="1";//门类
//		String xkIdString="101";//学科
//		String findsql="where a.mlid="+mlId+" and a.xkid="+xkIdString+";";
//		List<result> list=new resultDaoImpl().getResult(findsql);
//		for(result r:list) {
//			System.out.println(r);
//		}
//	}

	@Override
	public List<result> getResult(String strings) {
		String sql="select a.province,a.school,a.menlei,a.xueke,a.major\r\n" + 
				"from(\r\n" + 
				"select m.mlid,m.menlei,x.xkid,x.xueke,s.mjid,z.major,s.school,s.province\r\n" + 
				"from menlei m,xueke x,zhuanye z,schools s \r\n" + 
				"where m.mlid=x.mlid and x.xkid=z.xkid and z.mjid=s.mjid\r\n" + 
				") a\r\n" + strings;
		return queryForList(result.class, sql);
	}

}
