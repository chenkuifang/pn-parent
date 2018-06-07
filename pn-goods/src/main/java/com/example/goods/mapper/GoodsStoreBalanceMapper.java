package com.example.goods.mapper;

import com.common.entity.GoodsStoreBalance;
import com.common.entity.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 商品库存平衡映射层
 *
 * @author QuiFar
 * @version V1.0
 **/
@Mapper
public interface GoodsStoreBalanceMapper {

    /**
     * 根据ID获取信息
     *
     * @param id
     * @return
     */
    GoodsStoreBalance get(Integer id);

    /**
     * 添加
     *
     * @param goodsStoreBalance
     * @return
     */
    int add(GoodsStoreBalance goodsStoreBalance);

    /**
     * 根据条件获取列表
     *
     * @param params
     * @return
     */
    List<GoodsStoreBalance> list(Map<String, Object> params);

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
