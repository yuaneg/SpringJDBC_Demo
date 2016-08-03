package com.yuan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	/**
	 * 返回jsp 视图 在 application.properties 里面进行mvc 视图的配置..官方不推荐使用jsp..
	 * 返回jsp 视图需要在maven中添加tomcat-embed-jasper对jsp视图进行解析
	 * @param model
	 * @return
	 */
	@RequestMapping("/")
	public String helloWorld(Model model) {
		return "home";
	}

}
