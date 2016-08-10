package com.yuan.jdbc.text;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yuan.jdbc.dao.IDaoDemo;
import com.yuan.jdbc.model.Actor;


/**
 * 
 * @author yuaneg
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-config.xml")
public class DaoTest extends AbstractJUnit4SpringContextTests {
	@Resource
	private IDaoDemo daodemol;

	@Test
	public void queryIntTest() {
		int t = daodemol.queryForInt();
		assertThat(t, notNullValue());
	}

	@Test
	public void qureyForObject() {
		Object t = daodemol.queryForObject();
		assertTrue(t != null);

	}

	@Test
	public void queryForList() {
		daodemol.queryForList();

	}

	@Test
	public void queryForMap() {
		daodemol.queryForMap();

	}

	@Test
	public void queryForSqlRowSet() {
		daodemol.queryForSqlRowSet();
		Logger log = Logger.getLogger(DaoTest.class);
		log.info("信1息");
	}
	
	@Test
	public void queryForBean(){
		Actor actor  = daodemol.queryForBean();
		System.out.println(actor.toString());
	}
	
	@Test
	public void updateSql(){
		daodemol.update();
	}
	
	
	@Test
	public void queryListEntity(){
		List<Actor> actorList = daodemol.query();
		System.out.println(actorList.size());
		for(Actor ac : actorList){
			System.out.println(ac.toString());
		}
	}
	
	@Test
	public void insertBean2() throws Exception{
		try {
			daodemol.insertBean();
		} catch (Exception e) {
			assertThat(e, notNullValue());
			System.out.println("事务开启成功");
			return;
		}
		throw new Exception();
	}
}