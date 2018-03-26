package com.example.feign.fallback;


import com.example.entity.User;
import com.example.feign.UserClient;
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
