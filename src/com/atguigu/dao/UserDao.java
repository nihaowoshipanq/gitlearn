package com.atguigu.dao;

import com.atguigu.pojo.User;
/*
 * UserDao是一个接口，里面的方法用于用户注册、登录时查询数据库，与数据库进行交互
 */
public interface UserDao{
	/**
	 * 用于注册时检验用户名是否已存在
	 * @param username 用户名
	 * @return 如果返回null,说明没有这个用户,返回其他说明用户名已存在
	 */
	public User queryUserByUserName(String username) ; 
	
	/**
	 * 登录时检验用户名、密码是否匹配
	 * @param username 用户名
	 * @param password 密码
	 * @return 如果返回null,说明用户名或密码错误,反之亦然
	 */
	public User queryUserByUsernameAndPassword(String username,String password);
	
	/**
	 * 注册成功后保存用户信息到数据库中
	 * @param user 
	 * @return 返回-1表示操作失败,返回其他表示sql语句影响的行数
	 */
	public int saveUser(User user);
	

}
