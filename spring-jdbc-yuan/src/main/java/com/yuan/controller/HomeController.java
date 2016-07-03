package com.yuan.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yuan.jdbc.dao.IDaoDemo;
import com.yuan.jdbc.model.Actor;

@Controller
public class HomeController {
	@Autowired
	private IDaoDemo daoDemo;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/controller", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.error("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	/**
	 * 查询数量
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/count")
	public String searchCount(Model model){
		Integer count = daoDemo.queryForInt();
		model.addAttribute("actor",count);
		return "home";
	}
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/object")
	public String searchObject(Model model){
		Object obj = daoDemo.queryForObject();
		model.addAttribute("actor", (Actor)obj);
		return "home2";
	}
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/map")
	public String searchMap(Model model){
		List<?> map = daoDemo.queryForList();
		model.addAttribute("actor", map.toString());
		return "home";
	}
	
	/*----  getter-setter ----*/
	public IDaoDemo getDaoDemo() {
		return daoDemo;
	}

	public void setDaoDemo(IDaoDemo daoDemo) {
		this.daoDemo = daoDemo;
	}
	
}
