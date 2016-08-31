package com.yuan.jdbc.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
/**
 * @description 初始化JdbcTemplate 自动注入 dataSource
 * @author yuaneg
 * 2015年11月1日下午9:31:50
 */
public class BaseDao {
	/**
	 * 如果想用 JdbcDaoSupport 则不能用注解的方式自动注入 
	 * 只能用配置文件的方式 把dao层配置进bean 并注入属性 dataSource
	 * 原因是 JdbcDaoSupport 中的dataSource不是用的注解的方式自动注入
	 * 不管是继承JdbcDaoSupport还是如下 最终的目的都是用JdbcTemplate
	 */
	protected JdbcTemplate jdbcTemplate;
	protected DataSource datasource;
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.datasource=dataSource;
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}
}