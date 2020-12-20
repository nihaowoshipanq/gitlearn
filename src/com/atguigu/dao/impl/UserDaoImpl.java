package com.atguigu.dao.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao{
	
	/**
	 * ����ע��ʱ�����û����Ƿ��Ѵ���
	 */
	@Override
	public User queryUserByUserName(String username) {
		String sql="select * from t_user where username=?";		
		return queryForOne(User.class,sql,username);
	}
	
	/**
	 * ��¼ʱ�����û����������Ƿ�ƥ��
	 */
	@Override
	public User queryUserByUsernameAndPassword(String username,String password) {
		String sql="select * from t_user where username=? and password=?";
		return queryForOne(User.class,sql,username,password);
	}

	/**
	 * ע��ɹ��󱣴�ע����Ϣ�����ݿ�
	 */
	@Override
	public int saveUser(User user) {
		String sql= "insert into t_user(`username`,`password`,`email`) values(?,?,?)";
		return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
	}

}
