package com.atguigu.dao.impl;

import java.util.List;

import com.atguigu.dao.MenLeiDao;
import com.atguigu.pojo.MenLei;

public class MenLeiDaoImpl extends BaseDao implements MenLeiDao{
//	public static void main(String[] args) {
//		List<MenLei> list=new MenLeiDaoImpl().getAllMLList();
//		for(MenLei m:list) {
//			System.out.println(m);
//		}
//	}

	@Override
	public List<MenLei> getAllMLList() {
		String sql="select * from menlei";
		return queryForList(MenLei.class, sql);
	}

}
