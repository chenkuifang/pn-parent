package com.example.controller;

import com.common.User;
import com.example.feign.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制器
 */
@RestController
public class IndexController {

    @Autowired
    private UserClient userClient;

    @GetMapping("/index")
    public String index() {
        return "hello web";
    }

    @GetMapping("/get-user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userClient.getUser(id);
    }
}
