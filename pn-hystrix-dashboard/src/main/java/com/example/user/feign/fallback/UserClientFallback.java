package com.example.user.feign.fallback;


import com.example.user.entity.User;
import com.example.user.feign.UserClient;
import org.springframework.stereotype.Component;

/**
 * 回退类FeignClientFallback需实现Feign Client接口
 * FeignClientFallback也可以是public class，没有区别
 *
 * @author Quifar
 */
@Component
public class UserClientFallback implements UserClient {
    @Override
    public User getUser(Integer id) {
        User user = new User();
        user.setId(0);
        return user;
    }
}