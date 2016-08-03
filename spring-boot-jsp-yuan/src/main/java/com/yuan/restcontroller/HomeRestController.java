package com.yuan.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRestController {
	
	/**
	 * rest 风格
	 * @return
	 */
	@RequestMapping("/rest")
	public String home(){
		return "hello world";
	}
	
}
