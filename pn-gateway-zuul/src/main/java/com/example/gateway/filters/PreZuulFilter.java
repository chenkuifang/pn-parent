package com.example.gateway.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

        try {
            doSomething();
        } catch (Exception e) {
            System.err.println("catch exception");
            //context.setSendZuulResponse(false);
            context.set("error.message", e.getMessage());
            context.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            context.set("error.exception", e.getCause());
        }

//        //http://172.16.171.96:8085/user/10001?token=token
//        if (!"token".equals(token)) {
//            context.setSendZuulResponse(false);
//            context.setResponseStatusCode(401);
//            context.setResponseBody("auth fail");
//            return null;
//        }
        logger.info("请求成功");
        return null;
    }

    private void doSomething() {
        throw new RuntimeException("Exist some errors...");
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
