package com.example.order.controller;

import com.common.constant.Constants;
import com.common.entity.Order;
import com.example.order.MqProducer;
import com.example.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 用户控制类
 *
 * @author QuiFar
 * @version V1.0
 **/
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private MqProducer mqProducer;

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable("id") Integer id) {
        return orderService.get(id);
    }

    @GetMapping("/list")
    public List<Order> list() {
        return orderService.list(new HashMap<>());
    }

    @GetMapping("/add")
    public int add() {
        String orderSid;
        try {
            orderSid = orderService.getNewOrderSid();
        } catch (Exception e) {
            log.info(e.getMessage());
            return Constants.FAIL_CODE;
        }

        Order order = new Order();
        order.setOrderSid(orderSid);
        order.setPaySid("xxxxxxxx1");
        order.setPayWay(1);
        order.setGoodsId(10001);
        order.setGoodsName("苹果X");
        order.setPrice(new BigDecimal(100));
        order.setAmount(1);

        order.setCreateTime(new Date());
        order.setStatus(0);
        return orderService.add(order);
    }

    @GetMapping("/add-order/{userId}/{goodsId}")
    public void AddOrder(@PathVariable("userId") Integer userId, @PathVariable("goodsId") Integer goodsId) {
        log.info("创建订单开始------");
        String orderSid;
        try {
            orderSid = orderService.getNewOrderSid();
        } catch (Exception e) {
            log.info("创建订单失败。原因：创建订单编码出错");
            return;
        }

        Order order = new Order();
        order.setOrderSid(orderSid);
        order.setPaySid("xxxxxxxx1");
        order.setPayWay(1);
        order.setGoodsId(goodsId);
        order.setGoodsName("苹果X");
        order.setPrice(new BigDecimal(100));
        order.setAmount(1);
        order.setCreateId(userId);
        order.setCreateTime(new Date());
        order.setStatus(0);

        int flag = orderService.add(order);

        // 创建失败
        if (flag == 0) {
            return;
        }

        // 发布消息
        mqProducer.send("createOrder", order);

        // 调用支付接口

    }

}

