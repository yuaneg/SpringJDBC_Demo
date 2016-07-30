package com.yuan.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {
	
	/**
	 * 通过 @ModelAttribute 或者是通过 @RequestParam("name2")
	 * 这种写法参数的数量必须是固定的
	 * @param redirect
	 * @param rename
	 * @param name2
	 * @return
	 */
	@RequestMapping("/redirect")
	public String redirect(RedirectAttributes redirect, @ModelAttribute("rename") String rename,
			@RequestParam("name2") String name2) {
		rename = "通过重定向过来的参数:"+rename;
		// addflashattribute 的方式可以通过重定向的方式传值
		redirect.addFlashAttribute("rename", rename + ":" + name2);
		return "redirect:/name";
	}
	
}
