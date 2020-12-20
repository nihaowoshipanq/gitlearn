package com.atguigu.dao.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao{
	
	/**
	 * 用于注册时检验用户名是否已存在
	 */
	@Override
	public User queryUserByUserName(String username) {
		String sql="select * from t_user where username=?";		
		return queryForOne(User.class,sql,username);
	}
	
	/**
	 * 登录时检验用户名、密码是否匹配
	 */
	@Override
	public User queryUserByUsernameAndPassword(String username,String password) {
		String sql="select * from t_user where username=? and password=?";
		return queryForOne(User.class,sql,username,password);
	}

	/**
	 * 注册成功后保存注册信息到数据库
	 */
	@Override
	public int saveUser(User user) {
		String sql= "insert into t_user(`username`,`password`,`email`) values(?,?,?)";
		return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
	}

}
