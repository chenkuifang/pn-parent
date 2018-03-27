package com.example.goods.feign;

import com.common.entity.User;
import com.example.goods.feign.fallback.UserClientFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * user 服务类
 *
 * @author QuiFar
 */

@FeignClient(name = "pn-user", fallback = UserClientFallback.class)
public interface UserClient {

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    User getUser(@PathVariable("id") Integer id);
}
