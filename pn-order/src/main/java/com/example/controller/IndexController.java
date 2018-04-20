package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制器
 *
 * @author QuiFar
 */
@RestController
public class IndexController {

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/index")
    public String index() {
        return "hello order";
    }

    @GetMapping("/get-services")
    public String getServices() {
        return discoveryClient.getServices().toString();
    }

}
