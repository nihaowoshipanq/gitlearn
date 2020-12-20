package com.atguigu.util;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import java.sql.Connection;

public class JDBCUtil {


	
	    private static DruidDataSource dataSource;
	    
	    static {        
	        try {
	            Properties properties=new Properties();
//	            //��ȡjdbc.properties���������ļ�
	            InputStream is=JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
//	            //�����м�������
	            properties.load(is);
//	            System.out.println(properties.get("password"));
//	            //�������ݿ����ӳ�
	            dataSource= (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
//	        	dataSource= new DruidDataSource();
//
//	        	dataSource.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=UTC&characterEncoding=utf8");
//	        	dataSource.setUsername("root");
//	        	dataSource.setPassword("123456");
//	        	dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//	        	dataSource.setInitialSize(5);
//	        	dataSource.setMaxActive(10);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	    /**
	     * ��ȡ���ݿ����ӳ��е�����
	     * @return �������null,˵������ʧ��,��ֵ���ǻ�ȡ���ӳɹ�
	     */
	    public static Connection getConnection() {
	        Connection conn=null;
	        
	        try {
	            conn=(Connection)dataSource.getConnection();
	        }catch(Exception e) {
	            e.printStackTrace();
	        }
	        
	        return conn;
	    }
	    
	    /**
	     * �ر����ӣ��Ż����ݿ����ӳ�
	     * @param conn
	     */
	    public static void close(Connection conn) {
	        if(conn!=null) {
	            try {
	                conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	

}
