package com.example.order.feign;

import com.common.entity.Order;
import com.example.order.feign.fallback.OrderClientFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;

/**
 * order 服务类
 *
 * @author QuiFar
 */

@FeignClient(name = "pn-order", fallback = OrderClientFallback.class)
public interface OrderClient {

    /**
     * 获取单个订单
     *
     * @param id 订单ID
     * @return
     */
    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    Order getOrder(@PathVariable("id") Integer id);

    /**
     * 获取订单列表
     *
     * @return
     */
    @RequestMapping(value = "order/list", method = RequestMethod.GET)
    List<Order> list();

    /**
     * 增加一个订单
     *
     * @param userId  订单创建者
     * @param goodsId 商品id
     */
    @RequestMapping(value = "order/add-order/{userId}/{goodsId}", method = RequestMethod.GET)
    void addOrder(@PathVariable("userId") Integer userId, @PathVariable("goodsId") Integer goodsId);
}
