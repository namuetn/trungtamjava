package com.kieuthanhnam.demospringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	@GetMapping({"/2", "/hi"})
	public String hello() {
		return "hi";
	}
}
