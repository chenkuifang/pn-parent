package com.example.goods.service.impl;

import com.common.entity.GoodsStoreBalance;
import com.common.entity.Goods;
import com.example.goods.mapper.GoodsStoreBalanceMapper;
import com.example.goods.service.GoodsStoreBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 商品库存平衡服务层接口
 *
 * @author QuiFar
 * @version V1.0
 **/
@Service
public class GoodsStoreBalanceServiceImpl implements GoodsStoreBalanceService {

    @Autowired
    private GoodsStoreBalanceMapper goodsStoreBalanceMapper;

    @Override
    public GoodsStoreBalance get(Integer id) {
        return goodsStoreBalanceMapper.get(id);
    }

    @Override
    public int add(GoodsStoreBalance goodsStoreBalance) {
        return goodsStoreBalanceMapper.add(goodsStoreBalance);
    }

    @Override
    public List<GoodsStoreBalance> list(Map<String, Object> params) {
        return goodsStoreBalanceMapper.list(params);
    }

    @Override
    public List<Goods> listPage(Map<String, Object> params) {
        return goodsStoreBalanceMapper.listPage(params);
    }

    @Override
    public Integer countPage(Map<String, Object> params) {
        return goodsStoreBalanceMapper.countPage(params);
    }
}
