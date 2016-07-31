package com.yuan.aware.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yuan.aware.applicationContext.HelloBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-config.xml")
public class AwareTest {
	@Autowired
	private HelloBean hello;
	@Test
	public void test(){
		String result = hello.getHelloWord();
		System.out.println(result);
	}
	
}