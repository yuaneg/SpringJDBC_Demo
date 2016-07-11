package com.mail.yuan.test;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;
import com.yuan.mail.SimpleOrderManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:application-config.xml")
public class MailTest {
	@Resource
	private SimpleOrderManager orderManager;
	@Test
	public void Test(){
		orderManager.sendEmail();
	}
}
