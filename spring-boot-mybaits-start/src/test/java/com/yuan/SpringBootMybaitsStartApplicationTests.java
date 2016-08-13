package com.yuan;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yuan.mapper.SysUserMapper;
import com.yuan.model.SysUser;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMybaitsStartApplicationTests {
	
	@Autowired
	SysUserMapper sysUser;
	
	private static final Logger logger = LoggerFactory.getLogger(SpringBootMybaitsStartApplicationTests.class);
	
	@Test
	public void getUserTest() {
		try {
			SysUser s = sysUser.getUser(1L);
			logger.debug(s.toString());
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
	}
	
	@Test
	public void getUserListTest() {
		List<SysUser> list = sysUser.getUserList();
		for (SysUser sysUser : list) {
			logger.debug(sysUser.toString());
		}
	}

}
