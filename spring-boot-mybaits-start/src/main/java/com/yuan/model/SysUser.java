package com.yuan.model;

public class SysUser {
	private Long id;
	private String realName;
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
		return "SysUser [id=" + id + ", realName=" + realName + "]";
	}
	
}
