package com.yuan;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yuan.jdbc.dao.IDaoDemo;
import com.yuan.jdbc.model.Actor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootThymeleafYuanApplicationTests {

	@Autowired
	private IDaoDemo daodemol;

	@Test
	public void queryIntTest() {
		int t = daodemol.queryForInt();
		assertThat(t, notNullValue());
	}
	
	@Test
	public void queryForString() {
		String t = daodemol.queryForString();
		assertThat(t, notNullValue());
	}

	@Test
	public void queryForList() {
		daodemol.queryForList();

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
	public void insertBean(){
		daodemol.insertBean();
	}
	
}
