package com.example.controller;

import com.example.entity.User;
import com.example.feign.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private UserClient userClient;


    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userClient.getUser(id);
    }

}
