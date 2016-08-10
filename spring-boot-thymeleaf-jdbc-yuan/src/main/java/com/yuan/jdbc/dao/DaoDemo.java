package com.yuan.jdbc.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yuan.jdbc.common.BaseDao;
import com.yuan.jdbc.model.Actor;

/**
 * 
 * @author yuaneg
 *
 */

@Repository
@Transactional
public class DaoDemo extends BaseDao implements IDaoDemo{
	
	private String sql = "";
	
	@Override
	public int queryForInt(){
		sql="select count(*) from sys_user";
		int t=this.jdbcTemplate.queryForObject(sql,Integer.class);
		return t;
	}
	
	@Override
	public String queryForString() {
		sql="select t.real_name from sys_user t where id=?";
		String str = this.jdbcTemplate.queryForObject(sql,String.class,querMax());
		return str;
	}
	
	@Override
	public List<?> queryForList(){
		sql="select t.* from sys_user t";
		List<Map<String,Object>> list=this.jdbcTemplate.queryForList(sql);
		return list;
	}


	@Override
	public void update(){
		sql = "update sys_user set real_name = '侯美娇' ";
		this.jdbcTemplate.update(sql);
	}
	
	
	@Override
	public Actor queryForBean() {
		sql="select t.real_name,t.id from sys_user t where id=?";
		Actor actor = this.jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Actor>(Actor.class),querMax());
		return actor;
	}
	
	@Override
	public void insertBean() {
		sql = "insert sys_user (real_name) values ('袁恩光')";
		this.jdbcTemplate.execute(sql);
	}

	@Override
	public void delBean(int id) {
		sql = "delete from sys_user where id = ?";
		this.jdbcTemplate.update(sql,id);
	}
	
	private int querMax(){
		sql = "select max(id) from sys_user";
		int t=this.jdbcTemplate.queryForObject(sql,Integer.class);
		return t;
	}

	@Override
	public List<?> queryForList(Actor actor) {
		sql="select t.* from sys_user t where t.real_name = ?";
		List<Map<String,Object>> list=this.jdbcTemplate.queryForList(sql,actor.getRealName());
		return list;
	}

	@Override
	public List<Actor> query() {
		sql = "select * from sys_user";
		List<Actor> list = this.jdbcTemplate.query(sql,  new BeanPropertyRowMapper<Actor>(Actor.class));
		return list;
	}
	
}
