package com.example.pneureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * API网关，所有请求都经过该服务，由它来反向代理请求后端的服务
 * <p>
 * 例如：http://localhost:8085/user/user/10001;请求user 就会反向代理到pn-user后端服务
 * <p>
 * 
 * @author QuiFar
 * @date 2018年1月30日 下午10:24:10
 * @version V1.0
 */
@SpringBootApplication
@EnableZuulProxy
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
}
