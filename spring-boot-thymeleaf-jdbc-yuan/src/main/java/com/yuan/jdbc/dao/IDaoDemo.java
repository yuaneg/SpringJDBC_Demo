package com.yuan.jdbc.dao;

import java.util.List;

import com.yuan.jdbc.model.Actor;


public interface IDaoDemo {

	/**
	 * 查询整数类型
	 * @return
	 */
	public int queryForInt();

	/**
	 * 将查询结果转换成String
	 * @return
	 */
	public String queryForString();

	/**
	 * queryForList 
	 * 
	 */
	public List<?> queryForList();
	
	/**
	 * 执行 sql  this.jdbcTemplate.excute  一般call 语句 一般用于执行 存储的 sql
	 * 
	 */
	public void update();
	

	/**
	 * 返回javaBean
	 * 
	 * @return
	 */
	public Actor queryForBean();
	
	/**
	 * save 方法
	 */
	public void insertBean();
	
	/**
	 * 删除方法
	 */
	public void delBean(int id);
}
