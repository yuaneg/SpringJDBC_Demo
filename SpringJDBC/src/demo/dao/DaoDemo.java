package demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
/**
 * @description �����õ����ݿ��� cms ���������ݿ�
 * @author yuaneg
 * 2015��11��1������9:01:32
 */
@Repository
public class DaoDemo extends BaseDao{
	/**
	 * @description ������������  spring 3.2.2֮��jdbctemplate�е�queryForInt�Ѿ���ȡ���ˣ��� queryForObject ����
	 * @author yuaneg
	 * @return
	 * 2015��11��1������9:40:43
	 */
	@Deprecated
	public int queryForInt(){
		String sql="select count(*) from px_c_message";
		//��һ�ַ�ʽ
		int t=this.jdbcTemplate.queryForInt(sql);
		return t;
	}
	/**
	 * @description ��ȡObject ����  Object api��һ���� 8�з�ʽ
	 * @author yuaneg
	 * @return
	 * 2015��11��1������10:06:13
	 */
	public Object queryForObject(){
		String sql="select count(*) from px_c_message";
		// �ڶ������� ֻ���� integer.class �Ȱ�װ���.class  ��int.class �������   
		//queryForObject(String sql, Class<T> requiredType)
		//��һ������ �� sql �ڶ���������Ҫ��ѯ �� ����ֵ������  ���д 3 ������ ������ ������ ... (list) ǰ�� ? �ĸ�ֵ
		int t = this.jdbcTemplate.queryForObject(sql, Integer.class);
		sql="select message_name from px_c_message where message_id=?";
		String str = this.jdbcTemplate.queryForObject(sql,String.class,190L);
		
		//ֻ���������ַ���    �Ĳ��������� String sql, Class<T> requiredType, Object... args
		
		sql="select message_name from px_c_message where message_id=?";
		//���������� ָ�� Object ������������� ���Բ�д
		str=this.jdbcTemplate.queryForObject(sql,new Object[]{190},new int[]{1},String.class);
		str=this.jdbcTemplate.queryForObject(sql,new Object[]{190},String.class);
		
		//���� RowMapper �ӿڻ���Զ������
		sql="select message_name,message_id from px_c_message where message_id=?";
		Actor actor=this.jdbcTemplate.queryForObject(sql, new RowMapper<Actor>(){
			@Override
			public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {
				Actor actor=new Actor();
				//rs.getString(��ѯ��������eg message_name);
				actor.setName(rs.getString(1));
				actor.setId(rs.getLong(2));
				return actor;
			}			
		}, 190);
		//������ʽ ������ 1-4 �ı��� ֪ʶ�ѷ���ֵ�����ͱ����RowMapper
		
		//System.out.println(actor.getName()+"\t"+actor.getId());
		return t;
	}
	/**
	 * @description queryForList һ�����з�ʽ
	 * @author yuaneg
	 * @return
	 * 2015��11��3������11:23:07
	 */
	public List queryForList(){
		//��һ�� ֻ��sql������� �᷵�� List<Map<String,Object>> �᷵���ֶκ� ֵ�ļ�ֵ�� ��map����
		String sql="select t.* from px_c_message t";
		List<Map<String,Object>> list=this.jdbcTemplate.queryForList(sql);
		for(Map<String,Object> m:list){
			for(String str:m.keySet()){
				 //System.out.println("�ֶ�"+str+"\t"+"ֵ"+m.get(str));
			}
		}
		//�ڶ������  ��� �����͵� list ���� Ȼ���� class elementType ��ָ�� ???????????
		//List list2=this.jdbcTemplate.queryForList(sql, Map.class);
		//������ �� queryForList �� �ӵ���������  ָ�� sql ��ռλ����ֵ
		//this.jdbcTemplate.queryForList(sql,elementType.class,Object...args);
		//������   �ڵ�һ�ֵĻ����� �ӵڶ�������  Object...args
		//����ο� api �о�������
		return list;
	}
	
}