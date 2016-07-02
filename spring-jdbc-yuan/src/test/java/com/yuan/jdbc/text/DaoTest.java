package com.yuan.jdbc.text;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.yuan.jdbc.dao.IDaoDemo;


/**
 * 
 * @author yuaneg
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
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

}