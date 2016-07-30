package com.yuan.mvc.controller.blind;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = "text/html;charset=UTF-8")
public class BlindController {
	
	@RequestMapping("/blind")
	public String blindBean(@ModelAttribute Bean bean){
		System.out.println(bean.toString());
		return bean.toString();
	}
}
