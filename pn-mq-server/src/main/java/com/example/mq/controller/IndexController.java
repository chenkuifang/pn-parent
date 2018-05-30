package com.example.mq.controller;

import com.example.mq.service.MqProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author QuiFar
 * @version V1.0
 **/
@RestController
@RequestMapping("/mq")
public class IndexController {

    @Autowired
    private MqProducer mqProducer;

    @GetMapping("/index")
    public String index() {
        System.err.println("hello world");
        return "hello world";
    }

    @GetMapping("/send1")
    public void sendMsg() {
        System.err.println("send msg to test,test2");
        mqProducer.send("test", "test");
        mqProducer.send("test2", "test2");
    }

    @GetMapping("/send-msg/{topic}/{msg}")
    public void sendMsg(@PathVariable("topic") String topic, @PathVariable("msg") Object msg) {
        System.err.println("调用发信息接口");
        mqProducer.send(topic, msg);
    }

}
