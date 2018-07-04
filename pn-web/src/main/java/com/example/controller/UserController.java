package com.example.controller;

import com.common.entity.User;
import com.example.feign.UserClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户控制类
 *
 * @author QuiFar
 * @version V1.0
 **/
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    private static final String URL = "http://localhost:8085/user";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return restTemplate.getForObject(URL, User.class, params);
    }

    @GetMapping("/getByName")
    public User getByName(@RequestParam("userName") String userName) {
        String url = URL + "/getByName";
        Map<String, Object> params = new HashMap<>();
        params.put("userName", userName);

        return restTemplate.getForObject(url, User.class, params);
    }
}
