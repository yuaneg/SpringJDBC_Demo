package com.yuan.mybatisTest;

import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yuan.BaseTest;
import com.yuan.mybatis.model.MybatisUser;
import com.yuan.mybatis.service.ImybatisService;

public class MybatisTest extends BaseTest {
	public static final Logger log = LoggerFactory.getLogger(MybatisTest.class);
	@Resource
	private ImybatisService mybatisService;

	
	@Test
	public void insert(){
		MybatisUser user = new MybatisUser();
		user.setName("美娇");
		user.setAge(23);
		int t = mybatisService.insert(user);
		log.info(String.valueOf(t));
		//当执行insert 的时候成功改的时候返回1
		assertThat(t, CoreMatchers.is(1));
	}
	
	@Test
	public void update(){
		MybatisUser user = new MybatisUser();
		user.setId(2);
		user.setName("袁恩光");
		int t = mybatisService.updateByPrimaryKeySelective(user);
		log.info(String.valueOf(t));
		//当执行insert 的时候成功改的时候返回1
		assertThat(t, CoreMatchers.is(1));
	}
	
	/**
	 * 二级缓存测试  整体运行test 观察select2 和select的区别
	 * 前台把mapper.xml的缓存标签放开
	 */
	@Test
	public void select2() {
		MybatisUser user = mybatisService.selectByPrimaryKey(1);
		log.info(user.getName());
		assertThat(user,CoreMatchers.is(CoreMatchers.notNullValue()));
	}
	
	@Test
	public void select() {
		MybatisUser user = mybatisService.selectByPrimaryKey(1);
		log.info(user.getName());
		assertThat(user,CoreMatchers.is(CoreMatchers.notNullValue()));
	}
	
}
