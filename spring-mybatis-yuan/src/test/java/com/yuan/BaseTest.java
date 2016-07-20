package com.yuan;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:spring/*.xml" })
@Transactional
//对于测试单元 事务应该默认回滚
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class BaseTest {
	@Autowired
	private WebApplicationContext wac;
	/**
	 * mockMvc 的测试类
	 */
	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	public MockMvc getMockMvc() {
		return mockMvc;
	}
	
	@Test
	public void baseTes(){
		assertThat(mockMvc, notNullValue());
	}

}
