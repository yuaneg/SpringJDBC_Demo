package com.yuan.mybatis.model;

import java.io.Serializable;

public class MybatisUser implements Serializable{
    /**
	 * 如果要使用mybatis的二级缓存要实现 序列化
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String name;

    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}