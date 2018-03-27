package com.example.controller;

import com.common.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

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
    private RestTemplate restTemplate;

    @GetMapping("/{id}")
    public User get(@PathVariable("id") Integer id) {
        String goods = restTemplate.getForObject("http://localhost:8082/goods/10001", String.class);
        System.err.println("goods:" + goods);
        return userService.get(id);
    }

    public List<User> list() {
        return userService.list(new HashMap<>());
    }
}

