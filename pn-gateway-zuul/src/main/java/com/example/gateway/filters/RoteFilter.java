package com.example.gateway.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;

/**
 * 路由过滤器
 *
 * @author QuiFar
 */
@Slf4j
public class RoteFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "rote";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return RequestContext.getCurrentContext().getRouteHost() != null
                && RequestContext.getCurrentContext().sendZuulResponse();
    }

    @Override
    public Object run() {
        log.info("进入roteFilter");
        return null;
    }
}
