package com.atguigu.service.impl;



import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;

public class UserServiceImpl implements UserService{
	
	UserDao userService=new UserDaoImpl();
	/**
	 * ע��
	 */
	@Override
	public int registUser(User user) {
		return userService.saveUser(user);
		
	}

	@Override
	public User loginUser(User user) {
		//System.out.println("UserService--�û�����"+user.getUsername()+"���룺"+user.getPassword());
		return userService.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
		 
	}

	@Override
	public boolean existsUserName(String username) {
		if(userService.queryUserByUserName(username)==null) {//�û���Ϊ�գ���������
			return false;
		}
		return true;
	}

}
