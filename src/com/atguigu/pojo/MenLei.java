package com.atguigu.pojo;
//门类
public class MenLei {
	private int mlid;//门类代码
	private String menlei;//门类
	public MenLei() {}
	
	public MenLei(int mlid, String menlei) {
		super();
		this.mlid = mlid;
		this.menlei = menlei;
	}

	public int getMlid() {
		return mlid;
	}
	public void setMlid(int mlid) {
		this.mlid = mlid;
	}
	public String getMenlei() {
		return menlei;
	}
	public void setMenlei(String menlei) {
		this.menlei = menlei;
	}
	@Override
	public String toString() {
		return "MenLei [mlid=" + mlid + ", menlei=" + menlei + "]";
	}
	

}
