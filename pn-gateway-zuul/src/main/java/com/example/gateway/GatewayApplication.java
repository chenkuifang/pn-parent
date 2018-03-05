package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.example.gateway.filters.PreZuulFilter;

/**
 * API网关，所有请求都经过该服务，由它来反向代理请求后端的服务
 * <p>
 * 1.例如：http://localhost:8085/user/user/10001;请求user 就会反向代理到pn-user后端服务
 * <p>
 * 2.如果需要访问zuul的端点 endpoint($ZUUL_URL/routes) 时 ，需要注意的两个地方：需要引入Spring Boot
 * Actuator,否则会出现404;还有就是需要设置management.security.enabled = false
 * ，否则出现401；当然也可以直接引入spring security;
 * 
 * @author QuiFar
 * @date 2018年1月30日 下午10:24:10
 * @version V1.0
 */
@SpringBootApplication
@EnableZuulProxy // 允许反向代理
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	PreZuulFilter preZuulFilter() {
		return new PreZuulFilter();
	}
}
