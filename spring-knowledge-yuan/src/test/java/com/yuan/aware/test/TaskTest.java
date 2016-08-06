package com.yuan.aware.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yuan.task.async.AsyncDemo;
import com.yuan.task.scheduled.ScheduledDemo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-config.xml")
public class TaskTest {

	@Autowired
	private AsyncDemo async;
	@Autowired
	private ScheduledDemo scheduled;
	
	/**
	 * 输出结果的顺序是和电脑上cpu 有关的..
	 * 但是可以看到有些地方 输出的顺序并不是 按照顺序输出的
	 * 通过debug 可以看到创建了好多线程
	 */
	@Test
	public void testAsync() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			async.executionAsyncTask();
			async.executionAsyncTaskPlus();
		}
	}
	
	@Test
	public void scheduled(){
		scheduled.scheduledTest();
	}

}
