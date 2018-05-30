package com.example.goods.service;

import com.common.entity.Goods;

import java.util.List;
import java.util.Map;

/**
 * 商品服务类
 *
 * @author QuiFar
 * @version V1.0
 **/
public interface GoodsService {

    /**
     * 根据ID获取商品信息
     *
     * @param id
     * @return
     */
    Goods get(Integer id);

    /**
     * 添加商品
     *
     * @param goods
     * @return
     */
    int add(Goods goods);

    /**
     * 根据主键删除单个对象
     *
     * @param id 主键
     * @return
     */
    int remove(Integer id);

    /**
     * 根据主键数据批量删除商品
     *
     * @param ids 主键
     * @return
     */
    int removeBatch(String[] ids);

    /**
     * 根据主键ID更新单个对象
     *
     * @param goods 需要更新的对象
     * @return
     */
    int update(Goods goods);

    /**
     * 根据商品编码 修改库存和销量
     *
     * @param goodsId   商品编码
     * @param saleAmount 销量
     * @return
     */
    int update(Integer goodsId, Integer saleAmount);

    /**
     * 根据条件获取列表
     *
     * @param params
     * @return
     */
    List<Goods> list(Map<String, Object> params);

    /**
     * 根据条件获取用户列表(分页)
     *
     * @param params 1.过滤条件、2.分页参数必须包含page,limit
     * @return
     */
    List<Goods> listPage(Map<String, Object> params);

    /**
     * 根据条件获取用户列表总行数(一般提供分页使用)
     *
     * @param params
     * @return
     */
    Integer countPage(Map<String, Object> params);

}
