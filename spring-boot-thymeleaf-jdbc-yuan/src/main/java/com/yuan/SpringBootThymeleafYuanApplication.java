package com.yuan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//开启事务
@EnableTransactionManagement
public class SpringBootThymeleafYuanApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootThymeleafYuanApplication.class, args);
	}
}
