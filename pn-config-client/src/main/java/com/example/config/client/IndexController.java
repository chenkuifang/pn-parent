package com.example.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author QuiFar
 * @version V1.0
 * @Description: test
 * @date 2018年3月5日 下午8:51:42
 */
@RestController
//@RefreshScope // 需要用到curl 命令去刷新上下文的配置值
public class IndexController {

	@Value("${name}")
	private String name;

	@GetMapping("/index")
	public String index() {
		return name;
	}
}
