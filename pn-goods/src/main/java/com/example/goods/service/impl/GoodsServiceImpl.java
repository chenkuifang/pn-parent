package com.example.goods.service.impl;

import com.common.entity.Goods;
import com.common.entity.GoodsStoreBalance;
import com.example.goods.mapper.GoodsMapper;
import com.example.goods.mapper.GoodsStoreBalanceMapper;
import com.example.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 商品服务实现类
 *
 * @author QuiFar
 * @version V1.0
 **/
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private GoodsStoreBalanceMapper goodsStoreBalanceMapper;

    @Override
    public Goods get(Integer id) {
        return goodsMapper.get(id);
    }

    @Override
    public int add(Goods goods) {
        return goodsMapper.add(goods);
    }

    @Override
    public int remove(Integer id) {
        return goodsMapper.remove(id);
    }

    @Override
    public int removeBatch(String[] ids) {
        return goodsMapper.removeBatch(ids);
    }

    @Override
    public int update(Goods goods) {
        return goodsMapper.update(goods);
    }

    @Override
    @Transactional
    public int update(Integer goodsId, Integer saleAmount) {

        int flag1 = goodsMapper.updateStockAndSaleCount(goodsId, saleAmount);

        GoodsStoreBalance gb = new GoodsStoreBalance();
        gb.setGoodsId(goodsId);
        gb.setInCount(0);
        gb.setOutCount(saleAmount);
        gb.setCreateTime(new Date());
        gb.setCreateUser(10001);
        int flag2 = goodsStoreBalanceMapper.add(gb);
        return (flag1 > 0 && flag2 > 0) ? 1 : 0;
    }

    @Override
    public List<Goods> list(Map<String, Object> params) {
        return goodsMapper.list(params);
    }

    @Override
    public List<Goods> listPage(Map<String, Object> params) {
        return goodsMapper.listPage(params);
    }

    @Override
    public Integer countPage(Map<String, Object> params) {
        return goodsMapper.countPage(params);
    }
}
