package com.example.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author QuiFar
 * @version V1.0
 **/
@RestController
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

}
