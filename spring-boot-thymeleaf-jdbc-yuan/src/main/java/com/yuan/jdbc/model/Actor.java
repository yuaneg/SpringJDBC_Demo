package com.yuan.jdbc.model;


public class Actor {
	private String realName;
	private Long id;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	@Override
	public String toString() {
		return "Actor [realName=" + realName + ", id=" + id + "]";
	}
	
}