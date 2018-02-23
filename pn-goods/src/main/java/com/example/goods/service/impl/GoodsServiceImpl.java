package com.example.goods.service.impl;

import com.example.goods.entity.Goods;
import com.example.goods.service.GoodsService;

import java.util.List;
import java.util.Map;

/**
 * 商品服务实现类
 *
 * @author QuiFar
 * @version V1.0
 **/
public class GoodsServiceImpl implements GoodsService {
    @Override
    public Goods get(Integer id) {
        return null;
    }

    @Override
    public int add(Goods goods) {
        return 0;
    }

    @Override
    public int remove(Integer id) {
        return 0;
    }

    @Override
    public int removeBatch(String[] ids) {
        return 0;
    }

    @Override
    public Integer update(Goods goods) {
        return null;
    }

    @Override
    public List<Goods> list(Map<String, Object> params) {
        return null;
    }

    @Override
    public List<Goods> listPage(Map<String, Object> params) {
        return null;
    }

    @Override
    public Integer countPage(Map<String, Object> params) {
        return null;
    }
}
