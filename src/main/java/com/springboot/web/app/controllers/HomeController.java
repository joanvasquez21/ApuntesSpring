package com.springboot.web.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "redirect:https://www.google.com";
	}
}
