package com.atguigu.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.atguigu.util.JDBCUtil;

/*
 * ʹ��DbUtil ���߰���ʵ��jdbc�����ݿ�Ĳ���
 */

public abstract class BaseDao {
	private QueryRunner queryRunner=new QueryRunner();
	
	/**
	 * update() ��������ִ�У�Insert\Update\Delete ���
	 * @param sql ִ�е�sql���
	 * @param args sql��Ӧ�Ĳ���ֵ
	 * @return �������ݿ�ı���������������-1��˵��ִ��ʧ�ܡ�
	 */
	public int update(String sql,Object...args) {
		Connection connertion=JDBCUtil.getConnection();
		try {
			return queryRunner.update(connertion, sql, args);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(connertion);
		}
		return -1;
	}
	
	/**
	 * ��ѯ����һ�� javaBean �� sql ���(����ѯ���ת����һ��javaBean����)
	 * @param <T> ���ص����͵ķ���
	 * @param type  ���صĶ�������
	 * @param sql  ִ�е�sql���
	 * @param args sql��Ӧ�Ĳ���ֵ
	 * @return 
	 * 
	 * ����ֵ              ���������ṹ
     * <T> T        query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params)
     * BeanHandler����ResultSetHandler<T>�ӿڵ�ʵ���࣬�乹�췽��ΪBeanHandler(Class<? extends T> type)
	 */
	public <T> T queryForOne(Class<T> type,String sql,Object...args) {
		Connection connertion=JDBCUtil.getConnection();
		try {
			return queryRunner.query(connertion,sql, new BeanHandler<T>(type), args);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(connertion);
		}
		return null;
	}
	
	/**
	 * ��ѯ���ض�� javaBean �� sql ���
	 * @param <T> ���ص����͵ķ���
	 * @param type  ���صĶ�������
	 * @param sql  ִ�е�sql���
	 * @param args sql��Ӧ�Ĳ���ֵ
	 * @return 
	 * 
	 * ����ֵ              ���������ṹ
     * <T> T        query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params)
     * BeanListHandler��ResultSetת��ΪList<JavaBean>��ResultSetHandlerʵ����
	 */
	public <T> List<T> queryForList(Class<T> type,String sql,Object...args) {
		Connection connertion=JDBCUtil.getConnection();
		try {
			return queryRunner.query(connertion,sql, new BeanListHandler<T>(type), args);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(connertion);
		}
		return null;
	}
	/***
	 * ִ�з���һ��һ�е� sql ���
	 *   @param sql ִ�е� sql ���
	 *   @param args sql ��Ӧ�Ĳ���ֵ * 
	 *   @return 
	 *   */
	public Object queryForSingleValue(String sql,Object...args) {
		Connection conn = JDBCUtil.getConnection(); 
		try {
			return queryRunner.query(conn, sql, new ScalarHandler(), args); 
		} catch (Exception e) { 
			e.printStackTrace(); 
		} finally { 
			JDBCUtil.close(conn); 
		}
		return null;
	}
	
	
	
}
