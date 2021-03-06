package com.example.order.mapper;

import com.common.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 用户表映射接口
 *
 * @author QuiFar
 * @version V1.0
 */
@Mapper
public interface OrderMapper {
    /**
     * 根据主键删除单个对象
     *
     * @param id 主键
     * @return
     */
    Integer remove(Integer id);

    /**
     * 根据主键数据批量删除用户
     *
     * @param id 主键
     * @return
     */
    Integer removeBatch(String[] ids);

    /**
     * 根据主键ID更新单个对象
     *
     * @param order 需要更新的对象
     * @return
     */
    Integer update(Order order);

    /**
     * 根据订单ID修改状态
     *
     * @param orderId 订单Id
     * @param status  需要修改的状态
     * @return
     */
    Integer updateStatus(@Param("orderId") Integer orderId, @Param("status") Integer status);

    /**
     * 新增
     *
     * @param order
     * @return
     */
    Integer add(Order order);

    /**
     * 根据主键获取单个对象
     *
     * @param id
     * @return
     */
    Order get(Integer id);

    /**
     * 创建订单SID
     *
     * @return
     */
    String getNewOrderSid();

    /**
     * 根据条件获取列表
     *
     * @param params
     * @return
     */
    List<Order> list(Map<String, Object> params);

    /**
     * 根据条件获取用户列表(分页)
     *
     * @param 1.过滤条件、2.分页参数必须包含page,limit
     * @return
     */
    List<Order> listPage(Map<String, Object> params);

    /**
     * 根据条件获取用户列表总行数(一般提供分页使用)
     *
     * @param params
     * @return
     */
    Integer countPage(Map<String, Object> params);

}
