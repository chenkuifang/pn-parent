package com.example.goods.feign.fallback;


import com.common.entity.User;
import com.example.goods.feign.UserClient;
import org.springframework.stereotype.Component;

/**
 * Fallback 类为了出现异常是返回默认类
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
