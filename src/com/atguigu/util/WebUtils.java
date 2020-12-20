package com.atguigu.util;

import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtils {
	

	/** 
	 * 把 Map 中的值注入到对应的 JavaBean 属性中。 
	 * @param value
	 * @param bean 
	 * */
	public static <T> T copyParamToBean(Map value,T bean) {
		try {
			BeanUtils.populate(bean, value);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return bean;
	}
	
	/**
	 * 将字符串转换为int类型的数据
	 * @param strInt 要转换的字符串
	 * @param defaultValue 当程序出错时的默认值
	 * @return 返回转换后的值
	 */
	public static int parseInt(String strInt,int defaultValue) {
		try {
			if(strInt!=null) {
				return Integer.parseInt(strInt);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return defaultValue;
		
	}

}
