package com.atguigu.service.impl;



import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;

public class UserServiceImpl implements UserService{
	
	UserDao userService=new UserDaoImpl();
	/**
	 * 注册
	 */
	@Override
	public int registUser(User user) {
		return userService.saveUser(user);
		
	}

	@Override
	public User loginUser(User user) {
		//System.out.println("UserService--用户名："+user.getUsername()+"密码："+user.getPassword());
		return userService.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
		 
	}

	@Override
	public boolean existsUserName(String username) {
		if(userService.queryUserByUserName(username)==null) {//用户名为空，即不存在
			return false;
		}
		return true;
	}

}
