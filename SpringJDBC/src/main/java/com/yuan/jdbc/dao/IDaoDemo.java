package com.yuan.jdbc.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public interface IDaoDemo {
	
	public int queryForInt();
	public Object queryForObject();
	public List<?> queryForList();
	public Map<String,Object> queryForMap();
	public void update();
	public SqlRowSet queryForSqlRowSet();
}
