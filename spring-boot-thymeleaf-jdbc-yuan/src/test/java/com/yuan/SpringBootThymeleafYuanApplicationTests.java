package com.yuan;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yuan.jdbc.dao.IDaoDemo;
import com.yuan.jdbc.model.Actor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootThymeleafYuanApplicationTests {

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

}
