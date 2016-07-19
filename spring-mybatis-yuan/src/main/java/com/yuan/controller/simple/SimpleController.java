package com.yuan.controller.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuan.mybatis.service.ImybatisService;

@Controller
public class SimpleController {
	@Autowired
	private ImybatisService mybatisService;
	
	/**
	 * 这样前台通过ajax 请求你能在success中取到name的值
	 * 如果是中文记得要加上 produces ="text/html;charset=utf-8"要不然会出现乱码的情况
	 * @return
	 */
	@RequestMapping(value = "/simple", produces = "text/html;charset=UTF-8")
	public @ResponseBody String simpleRequest(){
		String name = mybatisService.selectByPrimaryKey(2).getName();
		return name;
	}

}
