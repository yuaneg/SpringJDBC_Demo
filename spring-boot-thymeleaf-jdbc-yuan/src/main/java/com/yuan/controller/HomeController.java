package com.yuan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yuan.jdbc.dao.IDaoDemo;
import com.yuan.jdbc.model.Actor;

@Controller
public class HomeController {
	
	@Autowired
	private IDaoDemo daoDemo;
	
	@RequestMapping("/")
	public String home(Model model){
		model.addAttribute("name", "hello world  袁恩光");
		return "home";
	}
	
	@RequestMapping("/queryForInt")
	public ModelAndView queryForInt(ModelAndView modelAndView){
		int count = daoDemo.queryForInt();
		modelAndView.addObject("count", "查询到的数量是:"+count);
		modelAndView.setViewName("home");
		return modelAndView;
	}
	
	@RequestMapping("/queryForBean")
	public ModelAndView queryForBean(ModelAndView modelAndView){
		Actor actor = daoDemo.queryForBean();
		modelAndView.addObject("actor", actor);
		modelAndView.setViewName("actorName");
		return modelAndView;
	}
	
	@RequestMapping("/queryMap")
	public ModelAndView queryMap(ModelAndView modelAndView){
		List<?> list = daoDemo.queryForList();
		modelAndView.addObject("list", list);
		modelAndView.setViewName("foreach");
		return modelAndView;
	}
	
	@RequestMapping("/delete")
	public ModelAndView delBean(ModelAndView modelAndView, @RequestParam(name = "id") int id) {
		daoDemo.delBean(id);
		return queryMap(modelAndView);
	}
	
	@RequestMapping("/insert")
	public ModelAndView insert(ModelAndView modelAndView) {
		daoDemo.insertBean();
		return queryMap(modelAndView);
	}
	
	@RequestMapping("/update")
	public ModelAndView update(ModelAndView modelAndView) {
		daoDemo.update();
		return queryMap(modelAndView);
	}
	
}
