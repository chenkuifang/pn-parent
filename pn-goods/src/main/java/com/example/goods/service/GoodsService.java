package com.example.goods.service;

import com.example.goods.entity.Goods;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 商品服务类
 *
 * @author QuiFar
 * @version V1.0
 **/
@Service
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
    Integer update(Goods goods);

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
