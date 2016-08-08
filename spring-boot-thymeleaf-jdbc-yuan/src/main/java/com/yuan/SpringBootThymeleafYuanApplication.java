package com.yuan;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringBootThymeleafYuanApplication {
	
	/**
	 * 开启事务支持
	 * @param dataSource
	 * @return
	 */
	@Bean
	public PlatformTransactionManager txManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	/**
	 * 测试事务是否开启成功
	 * @param platformTransactionManager
	 * @return
	 */
	@Bean
	public Object testBean(PlatformTransactionManager platformTransactionManager) {
		System.out.println("事务开启成功" + platformTransactionManager.getClass().getName());
		return new Object();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootThymeleafYuanApplication.class, args);
	}
}
