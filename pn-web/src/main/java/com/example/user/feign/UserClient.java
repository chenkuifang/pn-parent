package com.example.user.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.user.entity.User;
import com.example.user.feign.fallback.UserClientFallback;

@FeignClient(name = "pn-user", fallback = UserClientFallback.class)
public interface UserClient {

    //@GetMapping("/get-user/{id}")
    @RequestMapping(value = "/get-user/{id}", method = RequestMethod.GET)
    User getUser(@PathVariable("id") Integer id);
}
