package com.atguigu.pojo;
//����
public class MenLei {
	private int mlid;//�������
	private String menlei;//����
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
