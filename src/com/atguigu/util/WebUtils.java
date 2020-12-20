package com.atguigu.util;

import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtils {
	

	/** 
	 * �� Map �е�ֵע�뵽��Ӧ�� JavaBean �����С� 
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
	 * ���ַ���ת��Ϊint���͵�����
	 * @param strInt Ҫת�����ַ���
	 * @param defaultValue ���������ʱ��Ĭ��ֵ
	 * @return ����ת�����ֵ
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
