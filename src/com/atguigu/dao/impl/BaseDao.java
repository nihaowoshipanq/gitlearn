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
 * 使用DbUtil 工具包来实现jdbc对数据库的操作
 */

public abstract class BaseDao {
	private QueryRunner queryRunner=new QueryRunner();
	
	/**
	 * update() 方法用来执行：Insert\Update\Delete 语句
	 * @param sql 执行的sql语句
	 * @param args sql对应的参数值
	 * @return 返回数据库改变的行数。如果返回-1，说明执行失败。
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
	 * 查询返回一个 javaBean 的 sql 语句(将查询结果转换成一个javaBean对象)
	 * @param <T> 返回的类型的泛型
	 * @param type  返回的对象类型
	 * @param sql  执行的sql语句
	 * @param args sql对应的参数值
	 * @return 
	 * 
	 * 返回值              方法参数结构
     * <T> T        query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params)
     * BeanHandler类是ResultSetHandler<T>接口的实现类，其构造方法为BeanHandler(Class<? extends T> type)
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
	 * 查询返回多个 javaBean 的 sql 语句
	 * @param <T> 返回的类型的泛型
	 * @param type  返回的对象类型
	 * @param sql  执行的sql语句
	 * @param args sql对应的参数值
	 * @return 
	 * 
	 * 返回值              方法参数结构
     * <T> T        query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params)
     * BeanListHandler将ResultSet转换为List<JavaBean>的ResultSetHandler实现类
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
	 * 执行返回一行一列的 sql 语句
	 *   @param sql 执行的 sql 语句
	 *   @param args sql 对应的参数值 * 
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
