package com.example.goods.controller;

import com.common.entity.Goods;
import com.example.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * 商品控制类
 *
 * @author QuiFar
 * @version V1.0
 **/
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 获取单个商品
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Goods get(@PathVariable("id") Integer id) {
        return goodsService.get(id);
    }

    /**
     * 获取商品信息列表
     *
     * @return
     */
    @RequestMapping("/list")
    public List<Goods> list() {
        return goodsService.list(new HashMap<>());
    }

}
