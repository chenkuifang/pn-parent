package com.example.feign;

import com.common.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.feign.fallback.UserClientFallback;

@FeignClient(name = "pn-user", fallback = UserClientFallback.class)
public interface UserClient {

    @RequestMapping(value = "/get-user/{id}", method = RequestMethod.GET)
    User getUser(@PathVariable("id") Integer id);
}
