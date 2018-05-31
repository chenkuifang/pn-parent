package com.example.user.feign.fallback;


import com.common.entity.Goods;
import com.example.user.feign.GoodsClient;
import org.springframework.stereotype.Component;

/**
 * Fallback 类为了出现异常是返回默认类
 * 回退类FeignClientFallback需实现Feign Client接口
 * FeignClientFallback也可以是public class，没有区别
 *
 * @author Quifar
 */
@Component
public class GoodsClientFallback implements GoodsClient {
    @Override
    public Goods get(Integer id) {
        Goods goods = new Goods();
        goods.setId(0);
        return goods;
    }
}
