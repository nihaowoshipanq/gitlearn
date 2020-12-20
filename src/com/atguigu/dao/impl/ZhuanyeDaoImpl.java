package com.atguigu.dao.impl;

import java.util.List;


import com.atguigu.dao.ZhuanyeDao;
import com.atguigu.pojo.Zhuanye;

public class ZhuanyeDaoImpl extends BaseDao implements ZhuanyeDao{
//	public static void main(String[] args) {
//		List<Zhuanye> list=new ZhuanyeDaoImpl().getAllZYList("101");
//		for(Zhuanye z:list) {
//			System.out.println(z);
//		}
//	}

	@Override
	public List<Zhuanye> getAllZYList(String mjid) {
		String sql="select * from zhuanye where xkid="+mjid;
		return queryForList(Zhuanye.class, sql);
	}

}
