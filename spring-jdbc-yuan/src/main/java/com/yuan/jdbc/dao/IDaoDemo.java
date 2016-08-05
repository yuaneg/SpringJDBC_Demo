package com.yuan.jdbc.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.transaction.annotation.Transactional;

import com.yuan.jdbc.model.Actor;
@Transactional
public interface IDaoDemo {
	/**
	 * 返回整数类型  spring 3.2.2之后，jdbctemplate中的queryForInt已经被取消了！用 queryForObject 代替
	 * @author yuaneg
	 * @return
	 * @date 2015年11月1日下午9:40:43
	 */
	public int queryForInt();
	/**
	 * 获取Object 类型  Object api中一共有 8中方式
	 * @author yuaneg
	 * @return
	 * 2015年11月1日下午10:06:13
	 */
	public Object queryForObject();
	/**
	 * queryForList 一共其中方式
	 * @author yuaneg
	 * @return
	 * 2015年11月3日下午11:23:07
	 */
	public List<?> queryForList();
	/**
	 * 查询 返回map类型
	 * @author yuaneg
	 * @return 
	 * @time 2015年11月7日上午12:06:11
	 */
	public Map<String,Object> queryForMap();
	public void update();
	public SqlRowSet queryForSqlRowSet();
	
	/**
	 * 返回javaBean
	 * @return
	 */
	public Actor queryForBean();
}
