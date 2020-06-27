package com.jfsfeb.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringMVCController {
	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	public ModelAndView showMessage() {
             ModelAndView modelAndView=new ModelAndView();
             modelAndView.setViewName("/WEB-INF/web.xml");
             return modelAndView;
	}
	
}
