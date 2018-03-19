package com.example.config.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: test
 * @author QuiFar
 * @date 2018年3月5日 下午8:51:42
 * @version V1.0
 */
@RestController
public class IndexController {

	@GetMapping("/index")
	public String index() {
		return "index";
	}
}
