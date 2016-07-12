package com.mail.yuan.test;

import static org.junit.Assert.assertTrue;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yuan.mail.Mail;
import com.yuan.mail.SimpleOrderManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:application-config.xml")
public class MailTest {
	@Resource
	private SimpleOrderManager orderManager;

	@Test
	public void Test() {
		orderManager.sendEmail();
	}
	
	@Test
	public void Test2() {
		Mail mail = new Mail("smtp.qq.com");
		mail.setNamePass("1534275298@qq.com", "q2");
		mail.setSubject("test");
		mail.setBody("再次测试");
		mail.setFrom("1534275298@qq.com");
		mail.setTo("1534915553@qq.com");
		boolean b = mail.sendOut();
		assertTrue(b);
	}

}
