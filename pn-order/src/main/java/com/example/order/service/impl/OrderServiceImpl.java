package com.example.order.service.impl;

import com.common.entity.Order;
import com.common.util.StringUtils;
import com.example.order.mapper.OrderMapper;
import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 用户服务层接口实现类
 *
 * @author QuiFar
 * @version V1.0
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Integer remove(Integer id) {
        // 1.判断是否有删除的权限
        // 2.操作删除
        return orderMapper.remove(id);
    }

    @Override
    public Integer removeBatch(String[] ids) {
        return orderMapper.removeBatch(ids);
    }

    @Override
    public Integer update(Order user) {
        return orderMapper.update(user);
    }

    @Override
    public Integer updateStatus(Integer orderId, Integer status) {
        return orderMapper.updateStatus(orderId, status);
    }

    @Override
    public Integer add(Order user) {
        return orderMapper.add(user);
    }

    @Override
    public List<Order> list(Map<String, Object> params) {
        return orderMapper.list(params);
    }

    @Override
    public Order get(Integer id) {
        return orderMapper.get(id);
    }

    @Override
    public String getNewOrderSid() throws Exception {
        String orderSid = orderMapper.getNewOrderSid();
        String prefix = StringUtils.getOrderSidPrefix();
        if (StringUtils.isEmpty(orderSid)) {
            return prefix + 100001;
        }

        String suffix = orderSid.substring(8);
        if (suffix.length() < 6) {
            throw new Exception("订单SID获取出现异常");
        }

        AtomicInteger atomicInteger = new AtomicInteger(Integer.parseInt(suffix));
        return prefix + atomicInteger.addAndGet(1);
    }

    @Override
    public List<Order> listPage(Map<String, Object> params) {
        return orderMapper.listPage(params);
    }

    @Override
    public Integer countPage(Map<String, Object> params) {
        return orderMapper.countPage(params);
    }

}
