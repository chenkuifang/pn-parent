package com.example.gateway.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Zuul前置过滤器，作用：签名校验、权限校验、请求限流等功能
 * 可参看RibbonRoutingFilter做
 *
 * @author QuiFar
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
        //logger.info("zuul过滤器执行了");

        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token = request.getParameter("token");

        //http://172.16.171.96:8085/user/10001?token=token
        if (!"token".equals(token)) {
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            context.setResponseBody("auth fail");
            return null;
        }
        System.err.println("请求成功");
        return null;

    }

    @Override
    public String filterType() {
        //pre、route、post
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

}
