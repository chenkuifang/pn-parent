package com.example.controller;

import com.common.entity.Goods;
import com.common.entity.User;
import com.example.feign.GoodsClient;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户控制类
 *
 * @author QuiFar
 * @version V1.0
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private GoodsClient goodsClient;

    @GetMapping("/{id}")
    public Map<String, Object> get(@PathVariable("id") Integer id) {
        Map<String, Object> result = new HashMap<>();
        Goods goods = goodsClient.get(10001);

        result.put("user",userService.get(id));
        result.put("goods",goods);
        return result;
    }

    public List<User> list() {
        return userService.list(new HashMap<>());
    }
}

