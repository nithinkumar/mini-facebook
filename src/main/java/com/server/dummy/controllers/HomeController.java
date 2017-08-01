package com.server.dummy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import server.dummy.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	UserService userService;

	@RequestMapping("/asd")
	public String home()
    {
		userService.dummy();
		return "index";
    }
	
}
