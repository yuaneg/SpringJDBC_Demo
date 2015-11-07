package test;
import static org.junit.Assert.*;

import static org.hamcrest.core.IsNull.*;
import javax.annotation.Resource;

import org.apache.log4j.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import demo.dao.DaoDemo;
/**
 * 
 * @author yuaneg
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class DaoTest extends AbstractJUnit4SpringContextTests{
	@Resource
	private DaoDemo daodemol;

	@Test
	public void queryIntTest() {
		int t = daodemol.queryForInt();
		assertThat(t,notNullValue());
	}
	
	@Test
	public void qureyForObject(){
		Object t=daodemol.queryForObject();
		assertTrue(t!=null);
		
	}
	
	@Test
	public void queryForList(){
		daodemol.queryForList();
		
	}

	@Test
	public void queryForMap(){
		daodemol.queryForMap();
		
	}
	@Test
	public void queryForSqlRowSet(){
		daodemol.queryForSqlRowSet();
		Logger log=Logger.getLogger(DaoTest.class);
		log.error("信1息");;
	}
	
}