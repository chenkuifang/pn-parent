package com.example.gateway.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * API 网关 异常统一捕获拦截器
 *
 * @author QuiFar
 * @version V1.0
 **/
@Slf4j
@Component
public class ErrorFilter extends ZuulFilter {

    /**
     * filterType 值：
     * pre：可以在请求被路由之前调用。
     * routing：在路由请求时候被调用。
     * post：在routing和error过滤器之后被调用。
     * error：处理请求时发生错误时被调用。
     *
     * @return
     */
    @Override
    public String filterType() {
        return "error";
    }

    /**
     * 通过int值来定义过滤器的执行顺序，数值越小优先级越高。
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 10;
    }

    /**
     * 返回一个boolean类型来判断该过滤器是否要执行。我们可以通过此方法来指定过滤器的有效范围。
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑
     * 在该函数中，我们可以实现自定义的过滤逻辑，来确定是否要拦截当前的请求，不对其进行后续的路由，
     * 或是在请求路由返回结果之后，对处理结果做一些加工等（聚合数据）。
     *
     * @return
     */
    @Override
    public Object run() {
        log.info("异常拦截器");
        RequestContext ctx = RequestContext.getCurrentContext();
        Throwable throwable = ctx.getThrowable();
        log.error("this is a ErrorFilter : {}", throwable.getCause().getMessage());
        ctx.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        ctx.set("error.exception", throwable.getCause());
        return null;
    }
}
