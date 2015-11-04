package demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
/**
 * @description 测试用的数据库是 cms 官网的数据库
 * @author yuaneg
 * 2015年11月1日下午9:01:32
 */
@Repository
public class DaoDemo extends BaseDao{
	/**
	 * @description 返回整数类型  spring 3.2.2之后，jdbctemplate中的queryForInt已经被取消了！用 queryForObject 代替
	 * @author yuaneg
	 * @return
	 * 2015年11月1日下午9:40:43
	 */
	@Deprecated
	public int queryForInt(){
		String sql="select count(*) from px_c_message";
		//第一种方式
		int t=this.jdbcTemplate.queryForInt(sql);
		return t;
	}
	/**
	 * @description 获取Object 类型  Object api中一共有 8中方式
	 * @author yuaneg
	 * @return
	 * 2015年11月1日下午10:06:13
	 */
	public Object queryForObject(){
		String sql="select count(*) from px_c_message";
		// 第二个参数 只能用 integer.class 等包装类的.class  用int.class 会出错误   
		//queryForObject(String sql, Class<T> requiredType)
		//第一个参数 是 sql 第二个参数是要查询 的 返回值的类型  如果写 3 个参数 第三个 参数是 ... (list) 前面 ? 的赋值
		int t = this.jdbcTemplate.queryForObject(sql, Integer.class);
		sql="select message_name from px_c_message where message_id=?";
		String str = this.jdbcTemplate.queryForObject(sql,String.class,190L);
		
		//只有以上两种方法    的参数类型是 String sql, Class<T> requiredType, Object... args
		
		sql="select message_name from px_c_message where message_id=?";
		//第三个参数 指定 Object 里面的整数类型 可以不写
		str=this.jdbcTemplate.queryForObject(sql,new Object[]{190},new int[]{1},String.class);
		str=this.jdbcTemplate.queryForObject(sql,new Object[]{190},String.class);
		
		//采用 RowMapper 接口获得自定义对象
		sql="select message_name,message_id from px_c_message where message_id=?";
		Actor actor=this.jdbcTemplate.queryForObject(sql, new RowMapper<Actor>(){
			@Override
			public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {
				Actor actor=new Actor();
				//rs.getString(查询参数名称eg message_name);
				actor.setName(rs.getString(1));
				actor.setId(rs.getLong(2));
				return actor;
			}			
		}, 190);
		//三种形式 是上面 1-4 的变种 知识把返回值的类型变成了RowMapper
		
		//System.out.println(actor.getName()+"\t"+actor.getId());
		return t;
	}
	/**
	 * @description queryForList 一共其中方式
	 * @author yuaneg
	 * @return
	 * 2015年11月3日下午11:23:07
	 */
	public List queryForList(){
		//第一种 只有sql的情况下 会返回 List<Map<String,Object>> 会返回字段和 值的键值对 的map类型
		String sql="select t.* from px_c_message t";
		List<Map<String,Object>> list=this.jdbcTemplate.queryForList(sql);
		for(Map<String,Object> m:list){
			for(String str:m.keySet()){
				 //System.out.println("字段"+str+"\t"+"值"+m.get(str));
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
	
}