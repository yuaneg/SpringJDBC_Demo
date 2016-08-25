package com.yuan.jdbc.text;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger logger = LoggerFactory.getLogger(DaoTest.class);
	@Resource
	private IDaoDemo daoDemo ;

	@Test
	public void queryIntTest() {
		int t = daoDemo.queryForInt();
		assertThat(t, notNullValue());
	}

//	@Test
//	public void qureyForObject() {
//		Object t = daodemol.queryForObject();
//		assertTrue(t != null);
//
//	}

	@Test
	public void queryForList() {
		daoDemo.queryForList();

	}

	@Test
	public void queryForMap() {
		daoDemo.queryForMap();

	}

	@Test
	public void queryForSqlRowSet() {
		daoDemo.queryForSqlRowSet();
		logger.info("信1息");
	}
	
//	@Test
//	public void queryForBean(){
//		Actor actor  = daoDemo.queryForBean();
//		logger.info(actor.toString());
//	}
//
	@Test
	public void updateSql(){
		daoDemo.update();
	}
	
	
	@Test
	public void queryListEntity(){
		List<Actor> actorList = daoDemo.query();
		System.out.println(actorList.size());
		for(Actor ac : actorList){
			logger.info(ac.toString());
		}
	}
	
	@Test
	public void insertBean2() throws Exception{
		try {
			daoDemo.insertBean();
		} catch (Exception e) {
			assertThat(e, notNullValue());
			logger.info("事务开启成功");
			return;
		}
		throw new Exception();
	}
}