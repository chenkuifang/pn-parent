package com.example.feign;

import com.common.entity.User;
import com.example.feign.fallback.UserClientFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * user 服务类
 *
 * @author QuiFar
 */

@FeignClient(name = "pn-user", fallback = UserClientFallback.class)
public interface UserClient {

    @GetMapping(value = "/user/{id}")
    User get(@PathVariable("id") Integer id);

    @GetMapping("/user/getByName")
    User getByName(@RequestParam("userName") String userName);
}
