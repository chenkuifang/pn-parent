package com.example.service.impl;

import com.common.entity.Order;
import com.common.util.StringUtils;
import com.example.mapper.OrderMapper;
import com.example.service.OrderService;
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
    private OrderMapper userMapper;

    @Override
    public Integer remove(Integer id) {
        // 1.判断是否有删除的权限
        // 2.操作删除
        return userMapper.remove(id);
    }

    @Override
    public Integer removeBatch(String[] ids) {
        return userMapper.removeBatch(ids);
    }

    @Override
    public Integer update(Order user) {
        return userMapper.update(user);
    }

    @Override
    public Integer add(Order user) {
        return userMapper.add(user);
    }

    @Override
    public List<Order> list(Map<String, Object> params) {
        return userMapper.list(params);
    }

    @Override
    public Order get(Integer id) {
        return userMapper.get(id);
    }

    @Override
    public String getNewOrderSid() throws Exception {
        String orderSid = userMapper.getNewOrderSid();
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
        return userMapper.listPage(params);
    }

    @Override
    public Integer countPage(Map<String, Object> params) {
        return userMapper.countPage(params);
    }

}
