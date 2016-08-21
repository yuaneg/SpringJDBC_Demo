package com.yuan.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.github.pagehelper.PageHelper;

@Configuration
@ComponentScan("com.yuan")
@PropertySource(value="classpath:jdbc.properties")
public class MybatisConfig implements EnvironmentAware{
	
	private String url;
	private String className;
	private String userName;
	private String password;
	

	/**
	 * environment 环境变量
	 */
	@Override
	public void setEnvironment(Environment evn) {
		RelaxedPropertyResolver rpr = new RelaxedPropertyResolver(evn,"dbcp.");
		this.url = rpr.getProperty("url");
		this.className = rpr.getProperty("classname");
		this.userName = rpr.getProperty("username");
		this.password = rpr.getProperty("password");
		//用上面的方式代替
		//this.word = evn.getProperty("dbcp.password");
	}
	
	/**
	 * sqlSessionFactoryBean 的配置
	 * @return
	 * @throws Exception
	 */
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		sqlSessionFactoryBean.setTypeAliasesPackage("com.yuan.model");
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
		//注入分页插件
		sqlSessionFactoryBean.setPlugins(new Interceptor[]{initPageHelper()});
		return sqlSessionFactoryBean;
	}
	
	/**
	 * 注入数据源
	 * @return
	 */
	@Bean
	public DataSource dataSource(){
		BasicDataSource bean = new BasicDataSource();
		bean.setDriverClassName(this.className);
		bean.setUrl(this.url);
		bean.setUsername(this.userName);
		bean.setPassword(this.password);
		bean.setValidationQuery("select 1 from dual");
		return bean;
	}
	
	/**
	 * 为mybatis 注入事务
	 * @return
	 */
	@Bean
	public DataSourceTransactionManager initTransaction(){
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
		dataSourceTransactionManager.setDataSource(dataSource());
		return dataSourceTransactionManager;
	}

	/**
	 * 初始化分页插件
	 * @return
	 */
	@Bean
	public PageHelper initPageHelper(){
		return new PageHelper();
	}
	
}
