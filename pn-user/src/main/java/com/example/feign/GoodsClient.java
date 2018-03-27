package com.example.feign;

import com.common.entity.Goods;
import com.example.feign.fallback.GoodsClientFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * user 服务类
 *
 * @author QuiFar
 */

@FeignClient(name = "pn-goods", fallback = GoodsClientFallback.class)
public interface GoodsClient {

    @GetMapping("/{id}")
    Goods get(@PathVariable("id") Integer id);
}
