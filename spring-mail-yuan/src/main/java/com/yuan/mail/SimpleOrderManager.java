package com.yuan.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SimpleOrderManager {
	@Autowired
	private MailSender senderYuan;
	@Autowired
	private SimpleMailMessage templateMessage;


	public void sendEmail() {		
		templateMessage.setTo("yuanenguang@126.com");
		templateMessage.setText("这是一封spring-mail的测试邮件");
		templateMessage.setSubject("测试邮件");
		try {
			this.senderYuan.send(templateMessage);
		} catch (MailException ex) {
			System.err.println(ex.getMessage());
		}
	}
}