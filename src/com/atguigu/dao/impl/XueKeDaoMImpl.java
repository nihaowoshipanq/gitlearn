package com.atguigu.dao.impl;

import java.util.List;

import com.atguigu.dao.XueKeDao;
import com.atguigu.pojo.MenLei;
import com.atguigu.pojo.XueKe;

public class XueKeDaoMImpl extends BaseDao implements XueKeDao{
//	public static void main(String[] args) {
//		List<XueKe> list=new XueKeDaoMImpl().getAllXKList("1");
//		for(XueKe m:list) {
//			System.out.println(m);
//		}
//	}

	@Override
	public List<XueKe> getAllXKList(String id) {
		String sql="select * from xueke where mlid="+id;
		return queryForList(XueKe.class, sql);
	}

}
