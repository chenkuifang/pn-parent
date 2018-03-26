package com.example.service.impl;

import com.example.entity.Order;
import com.example.mapper.OrderMapper;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
	public List<Order> listPage(Map<String, Object> params) {
		return userMapper.listPage(params);
	}

	@Override
	public Integer countPage(Map<String, Object> params) {
		return userMapper.countPage(params);
	}

}
