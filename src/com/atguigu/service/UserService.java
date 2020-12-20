package com.atguigu.service;

import com.atguigu.pojo.User;

/**
 * ҵ���ӿ�
 * @author pan
 *2020.06.25
 */
public interface UserService {
	/**
	 * ע���û�
	 * @param user 
	 *  @return �������-1,˵��ע��ʧ��,����������ֵ˵�����ݲ������ݿ�ɹ�
	 */
	public int  registUser(User user);
	/**
	 * ��¼
	 * @param user
	 * @return �������null,˵����¼ʧ��,������ֵ,�ǵ�¼�ɹ�
	 */
	public User loginUser(User user);
	/**
	 * ע��ʱ����û����Ƿ��Ѵ���
	 * @param username
	 * @return ����true��ʾ�û����Ѵ���,����false��ʾ�û�������
	 */
	public boolean existsUserName(String username);
}
