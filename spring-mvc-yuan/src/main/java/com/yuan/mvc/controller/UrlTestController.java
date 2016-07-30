package com.yuan.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RestController 相当于 controller+  @ResponseBody 会对所有的方法加上 responseBody
// responseBody 直接返回return 的结果
public class UrlTestController {
	
	/**
	 * 在model中设置attribute从前台取出
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/name")
	public String showName(Model model){
		model.addAttribute("name", "普通请求从后台取到的值 :袁恩光");
		return "name";
	}
	
}
