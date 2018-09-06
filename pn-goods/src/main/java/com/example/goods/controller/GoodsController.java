package com.example.goods.controller;

import com.common.entity.Goods;
import com.common.entity.User;
import com.example.goods.feign.UserClient;
import com.example.goods.service.GoodsService;
import com.example.mq.service.MqProducer;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private MqProducer mqProducer;

    @Autowired
    private UserClient userClient;

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

    @GetMapping("/send-msg")
    public void sendMsg() {
        log.info("发送消息------>>>>");
        mqProducer.send("test", "goods send a msg test");
    }

    @GetMapping("/user")
    public String getUser() {
        User user = userClient.getUser(10001);
        return user.toString();
    }

}
