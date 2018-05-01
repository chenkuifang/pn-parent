package com.example.gateway.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Zuul前置过滤器，作用：签名校验、权限校验、请求限流等功能
 * 可参看RibbonRoutingFilter做
 *
 * @author QuiFar
 * @version V1.0
 */
@Slf4j
public class PreZuulFilter extends ZuulFilter {

    @Override
    public String filterType() {
        //pre、route、post
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token = request.getParameter("token");

        //try {
        doSomething();
//        } catch (Exception e) {
//            //context.setSendZuulResponse(false);
//            context.set("error.message", e.getMessage());
//            context.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//            context.set("error.exception", e.getCause());
//        }

//        //http://172.16.171.96:8085/user/10001?token=token
//        if (!"token".equals(token)) {
//            context.setSendZuulResponse(false);
//            context.setResponseStatusCode(401);
//            context.setResponseBody("auth fail");
//            return null;
//        }
        log.info("进入preFilter");
        return null;
    }

    private void doSomething() {
        log.info("进入 doSomeThing method");
        throw new RuntimeException("Exist some errors...");
    }

}
