package com.atguigu.dao;

import com.atguigu.pojo.User;
/*
 * UserDao��һ���ӿڣ�����ķ��������û�ע�ᡢ��¼ʱ��ѯ���ݿ⣬�����ݿ���н���
 */
public interface UserDao{
	/**
	 * ����ע��ʱ�����û����Ƿ��Ѵ���
	 * @param username �û���
	 * @return �������null,˵��û������û�,��������˵���û����Ѵ���
	 */
	public User queryUserByUserName(String username) ; 
	
	/**
	 * ��¼ʱ�����û����������Ƿ�ƥ��
	 * @param username �û���
	 * @param password ����
	 * @return �������null,˵���û������������,��֮��Ȼ
	 */
	public User queryUserByUsernameAndPassword(String username,String password);
	
	/**
	 * ע��ɹ��󱣴��û���Ϣ�����ݿ���
	 * @param user 
	 * @return ����-1��ʾ����ʧ��,����������ʾsql���Ӱ�������
	 */
	public int saveUser(User user);
	

}
