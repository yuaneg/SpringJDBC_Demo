package com.yuan.jdbc.model;

public class Actor {
	private String real_name;
	private Long id;
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Actor [real_name=" + real_name + ", id=" + id + "]";
	}

	
}