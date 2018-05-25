package com.example.order.feign;

import com.common.entity.Order;
import com.example.order.feign.fallback.OrderClientFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * order 服务类
 *
 * @author QuiFar
 */

@FeignClient(name = "pn-order", fallback = OrderClientFallback.class)
public interface OrderClient {

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    Order getOrder(@PathVariable("id") Integer id);
}
