package test;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import javax.annotation.Resource;

import org.junit.Ignore;
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
		assertTrue(t > 0);
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
		
	}
	
}