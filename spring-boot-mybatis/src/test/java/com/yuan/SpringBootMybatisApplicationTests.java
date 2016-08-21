package com.yuan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuan.mapper.SysUserMapper;
import com.yuan.model.SysUser;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMybatisApplicationTests {
	
	@Autowired
	SysUserMapper sysUser;
	
	private static final Logger logger = LoggerFactory.getLogger(SpringBootMybatisApplicationTests.class);
	
	@Test
	public void getUserTest() {
		try {
			SysUser s = sysUser.getUser(1L);
			logger.info(s.toString());
		} catch (Exception e) {
			logger.warn(e.getMessage());
		}
	}
	
	/**
	 * 分页插件测试
	 */
	@Test
	public void getUserListTest() {
		PageHelper.startPage(1, 1);
		Page<SysUser> list = (Page<SysUser>) sysUser.getUserList();
		PageInfo<SysUser> pageInfo = list.toPageInfo();
		System.out.println(pageInfo.toString());
		for (SysUser sysUser : list) {
			System.out.println(sysUser.toString());
		}
	}

}
