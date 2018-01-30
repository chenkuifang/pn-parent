package com.example.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制器
 */
@RestController
public class IndexController {

	@GetMapping("/index")
	public String index() {
		return "hello web";
	}
}
