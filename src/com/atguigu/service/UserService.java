package com.atguigu.service;

import com.atguigu.pojo.User;

/**
 * 业务层接口
 * @author pan
 *2020.06.25
 */
public interface UserService {
	/**
	 * 注册用户
	 * @param user 
	 *  @return 如果返回-1,说明注册失败,若返回其他值说明数据插入数据库成功
	 */
	public int  registUser(User user);
	/**
	 * 登录
	 * @param user
	 * @return 如果返回null,说明登录失败,返回有值,是登录成功
	 */
	public User loginUser(User user);
	/**
	 * 注册时检查用户名是否已存在
	 * @param username
	 * @return 返回true表示用户名已存在,返回false表示用户名可用
	 */
	public boolean existsUserName(String username);
}
