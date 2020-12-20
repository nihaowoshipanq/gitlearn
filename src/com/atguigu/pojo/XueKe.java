package com.atguigu.pojo;
//学科
public class XueKe {
	private int xkid;//学科代码
	private String xueke;//学科
	private int mlid;//门类代码
	public int getXkid() {
		return xkid;
	}
	public void setXkid(int xkid) {
		this.xkid = xkid;
	}
	public String getXueke() {
		return xueke;
	}
	public void setXueke(String xueke) {
		this.xueke = xueke;
	}
	public int getMlid() {
		return mlid;
	}
	public void setMlid(int mlid) {
		this.mlid = mlid;
	}
	public XueKe(int xkid, String xueke, int mlid) {
		super();
		this.xkid = xkid;
		this.xueke = xueke;
		this.mlid = mlid;
	}
	@Override
	public String toString() {
		return "XueKe [xkid=" + xkid + ", xueke=" + xueke + ", mlid=" + mlid + "]";
	}
	public XueKe() {}
	

}
