package com.atguigu.pojo;

public class result {
	private String province;
	private String school;
	private String menlei;
	private String xueke;
	private String major;
	public result(String province, String school, String menlei, String xueke, String major) {
		super();
		this.province = province;
		this.school = school;
		this.menlei = menlei;
		this.xueke = xueke;
		this.major = major;
	}
	public result() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getMenlei() {
		return menlei;
	}
	public void setMenlei(String menlei) {
		this.menlei = menlei;
	}
	public String getXueke() {
		return xueke;
	}
	public void setXueke(String xueke) {
		this.xueke = xueke;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	@Override
	public String toString() {
		return "result [province=" + province + ", school=" + school + ", menlei=" + menlei + ", xueke=" + xueke
				+ ", major=" + major + "]";
	}
	
	

}
