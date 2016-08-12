package com.yuan;

import org.junit.Test;
import org.junit.runner.RunWith;
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
	@Test
	public void contextLoads() {
		SysUser s = sysUser.getUser(1L);
		System.out.println(s.toString());
	}

}
