package com.yuan.jdbc.common;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
/**
 * @description 初始化JdbcTemplate 自动注入 dataSource
 * @author yuaneg
 * 2015年11月1日下午9:31:50
 */
@Repository
public class BaseDao {
	protected JdbcTemplate jdbcTemplate;
	protected DataSource datasource;
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.datasource=dataSource;
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}
}