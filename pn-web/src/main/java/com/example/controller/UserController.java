package com.example.controller;

import com.common.entity.User;
import com.example.feign.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return userClient.get(id);
    }


    @GetMapping("/getByName")
    @ResponseBody
    public User getByName(@RequestParam("userName") String userName) {
        return userClient.getByName(userName);

    }
}
