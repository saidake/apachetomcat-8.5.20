package com.qf.bean;

public class RecordBean {
	private int pid;
	private String name;
	private String region;
	private String time;
	private String imgpath;
	private String category;
	
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}




	
	
	
	
	@Override
	public String toString() {
		return "RecordBean [pid=" + pid + ", name=" + name + ", region=" + region + ", time=" + time + ", imgpath=" + imgpath
				+ ", category=" + category + "]";
	}
	
}
