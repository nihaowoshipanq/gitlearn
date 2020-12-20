package com.atguigu.pojo;

public class Zhuanye {
	private int mjid;
	private String major;
	private int xkid;
	public Zhuanye(int mjid, String major, int xkid) {
		super();
		this.mjid = mjid;
		this.major = major;
		this.xkid = xkid;
	}
	public Zhuanye() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getMjid() {
		return mjid;
	}
	public void setMjid(int mjid) {
		this.mjid = mjid;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getXkid() {
		return xkid;
	}
	public void setXkid(int xkid) {
		this.xkid = xkid;
	}
	@Override
	public String toString() {
		return "Zhuanye [mjid=" + mjid + ", major=" + major + ", xkid=" + xkid + "]";
	}
	

}
