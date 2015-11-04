package demo.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
/**
 * @description ��ʼ��JdbcTemplate �Զ�ע�� dataSource
 * @author yuaneg
 * 2015��11��1������9:31:50
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