package com.yuan.mvc.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//解决中文乱码的问题
@RequestMapping(produces = "text/html;charset=UTF-8")
public class PathVariableController {

	@RequestMapping("/pathvariable/{rename}/{name2}")
	public String pathVariable(@PathVariable String rename, @PathVariable String name2) {
		String reval = "通过请求地址带参数的方式传值:"+rename+","+name2;
		return reval;
	}
}
