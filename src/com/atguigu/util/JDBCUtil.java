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
//	            //读取jdbc.properties属性配置文件
	            InputStream is=JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
//	            //从流中记载数据
	            properties.load(is);
//	            System.out.println(properties.get("password"));
//	            //创建数据库连接池
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
	     * 获取数据库连接池中的连接
	     * @return 如果返回null,说明连接失败,有值就是获取连接成功
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
	     * 关闭连接，放回数据库连接池
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
