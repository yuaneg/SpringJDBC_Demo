package com.yuan.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.yuan.jdbc.common.BaseDao;
import com.yuan.jdbc.model.Actor;
/**
 * @description 测试用的数据库是  mysql 数据库
 * @author yuaneg
 * 2015年11月1日下午9:01:32
 */

@Repository
public class DaoDemo extends BaseDao implements IDaoDemo{
	
	@Override
	public int queryForInt(){
		String sql="select count(*) from sys_user";
		//第一种方式
		int t=this.jdbcTemplate.queryForObject(sql,Integer.class);
		return t;
	}

	@SuppressWarnings("unused")
	@Override
	public Object queryForObject(){
		String sql="select count(*) from sys_user";
		// 第二个参数 只能用 integer.class 等包装类的.class  用int.class 会出错误   
		//queryForObject(String sql, Class<T> requiredType)
		//第一个参数 是 sql 第二个参数是要查询 的 返回值的类型  如果写 3 个参数 第三个 参数是 ... (list) 前面 ? 的赋值
		int t = this.jdbcTemplate.queryForObject(sql, Integer.class);
		sql="select t.real_name from sys_user t where id=?";
		String str = this.jdbcTemplate.queryForObject(sql,String.class,1L);
		
		//只有以上两种方法    的参数类型是 String sql, Class<T> requiredType, Object... args
		
		sql="select t.real_name from sys_user t where id=?";
		//第三个参数 指定 Object 里面的整数类型 可以不写
		str=this.jdbcTemplate.queryForObject(sql,new Object[]{1},new int[]{1},String.class);
		str=this.jdbcTemplate.queryForObject(sql,new Object[]{1},String.class);
		
		//采用 RowMapper 接口获得自定义对象
		sql="select t.real_name,t.id from sys_user t where id=?";
		Actor actor=this.jdbcTemplate.queryForObject(sql, new RowMapper<Actor>(){
			@Override
			public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {
				Actor actor=new Actor();
				//rs.getString(查询参数名称eg message_name);
				actor.setReal_name(rs.getString(1));
				actor.setId(rs.getLong(2));
				return actor;
			}			
		}, 1);
		//三种形式 是上面 1-4 的变种 知识把返回值的类型变成了RowMapper
		System.out.println(actor.getReal_name()+"\t"+actor.getId());
		return actor;
	}

	@Override
	public List<?> queryForList(){
		//第一种 只有sql的情况下 会返回 List<Map<String,Object>> 会返回字段和 值的键值对 的map类型
		String sql="select t.* from sys_user t";
		List<Map<String,Object>> list=this.jdbcTemplate.queryForList(sql);
		for(Map<String,Object> m:list){
			for(String str:m.keySet()){
				 System.out.println("字段"+str+"\t"+"值"+m.get(str));
			}
		}
		//第二种情况  获得 反类型的 list 集合 然后在 class elementType 中指定 ???????????
		//List list2=this.jdbcTemplate.queryForList(sql, Map.class);
		//第三种 在 queryForList 中 加第三个参数  指定 sql 中占位符的值
		//this.jdbcTemplate.queryForList(sql,elementType.class,Object...args);
		//第四种   在第一种的基础上 加第二个参数  Object...args
		//其余参考 api 感觉不常用
		return list;
	}

	@Override
	public Map<String,Object> queryForMap() {
		// 这个查询 只是针对 查询结果 2个 值的
		String sql="select t.real_name,t.id from sys_user t where real_name='袁恩光'";
		Map<String,Object> map=null;
		try{
		map=this.jdbcTemplate.queryForMap(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return map;
	}
	/**
	 * @description 
	 * @author yuaneg
	 * @time 2015年11月7日上午12:26:09
	 */
	@Override
	public void update(){
		//this.jdbcTemplate.update(sql);
	}
	//执行 sal  this.jdbcTemplate.excute  一般
	// call 语句 一般用于执行 存储的 sql

	@Override
	public SqlRowSet queryForSqlRowSet(){
		String sql="select t.* from sys_user t";
		SqlRowSet rowset=this.jdbcTemplate.queryForRowSet(sql);
		System.out.println(rowset.getRow());
		return rowset;
	}

	@Override
	public Actor queryForBean() {
		String sql="select t.real_name,t.id from sys_user t where id=?";
		//actor 的属性必须是字段类型的小写形式    比如传入 Actor.class
		Actor actor = this.jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Actor>(Actor.class),1);
		return actor;
	}
}
