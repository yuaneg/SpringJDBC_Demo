package com.yuan.aware.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.yuan.applicationcontext.event.HelloBean;

public class AwareTest extends BaseTest{
	@Autowired
	private HelloBean hello;

	@Test
	public void test() {
		String result = hello.getHelloWord();
		System.out.println(result);
	}

}