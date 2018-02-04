package com.example.user;

import com.example.user.entity.User;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制器
 */
@RestController
public class IndexController {
    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String index() {
        return "hello user";
    }

    @GetMapping("/get-user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        User user = userService.get(id);
        return user;
    }
}
