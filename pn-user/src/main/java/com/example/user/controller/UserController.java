package com.example.user.controller;

import com.common.bean.JsonResult;
import com.common.entity.User;
import com.common.util.JsonResultUtils;
import com.example.mq.service.MqProducer;
import com.example.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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
    @Autowired
    private UserService userService;

    @Autowired
    private MqProducer mqProducer;

    /**
     * 根据Id获取单个User对象
     *
     * @param id 编码
     * @return
     */
    @GetMapping("/{id}")
    public User get(@PathVariable("id") Integer id) {
        return userService.get(id);
    }

    /**
     * 通过用户名获取User对象
     *
     * @param userName 名称
     * @return
     */
    @GetMapping("/getByName")
    public User getByName(@RequestParam("userName") String userName) {
        return userService.getByUserName(userName);
    }

    /**
     * 获取所有用户列表
     *
     * @return
     */
    @GetMapping("/list")
    public List<User> list() {
        return userService.list(new HashMap<>());
    }

    /**
     * 根据条件获取列表
     *
     * @param params 页面请求参数
     * @return
     */
    @GetMapping("/listPage")
    public JsonResult listPage(@RequestParam Map<String, Object> params) {
        List<User> list = userService.listPage(params);
        int countPage = userService.countPage(params);
        return JsonResultUtils.jsonPageResult(list, countPage);
    }

    @GetMapping("/send-msg")
    public String sendMsg() {
        log.info("user service send a msg test");
        mqProducer.send("test4", "user service send a msg test");
        return "ok";
    }
}

