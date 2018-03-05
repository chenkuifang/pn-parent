package com.example.gateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;

/**
 * @Description: Zuul前置过滤器
 * @author QuiFar
 * @date 2018年3月3日 下午12:33:17
 * @version V1.0
 */
public class PreZuulFilter extends ZuulFilter {

	private static final Logger logger = LoggerFactory.getLogger(PreZuulFilter.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		logger.info("zuul过滤器执行了");
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
