package com.example.order.feign.fallback;

import com.common.entity.Order;
import com.example.order.feign.OrderClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Fallback 类为了出现异常是返回默认类
 * 回退类FeignClientFallback需实现Feign Client接口
 * FeignClientFallback也可以是public class，没有区别
 *
 * @author Quifar
 */
@Component
@Slf4j
public class OrderClientFallback implements OrderClient {
    @Override
    public Order getOrder(Integer id) {
        Order order = new Order();
        order.setOrderId(0);
        return order;
    }

    @Override
    public List<Order> list() {
        return null;
    }

    @Override
    public void addOrder(Integer userId, Integer goodsId) {
        log.info("新增订单失败");
    }
}
