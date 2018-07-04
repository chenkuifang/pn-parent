package com.example.order.mqService;

import com.alibaba.fastjson.JSONObject;
import com.example.mq.service.MqProducer;
import com.example.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 商品消费者
 *
 * @author QuiFar
 * @version V1.0
 **/
@Component
@Slf4j
public class GoodsConsumer {

    @Autowired
    private MqProducer mqProducer;

    @Autowired
    private OrderService orderService;

    /**
     * 获取商品服务的确认信息
     *
     * @param data
     */
    @KafkaListener(topics = {"handleGoodsStockAndSaleCount"})
    public void processOrderMsg(ConsumerRecord<?, ?> data) {
        JSONObject goodsAckMsg = JSONObject.parseObject((String) data.value());
        System.err.println("接受到商品服务的确认消息:" + goodsAckMsg.toJSONString());

        // 确认是否扣减库存成功
        Integer goodsId = goodsAckMsg.getInteger("goodsId");
        Integer orderId = goodsAckMsg.getInteger("orderId");
        Integer result = goodsAckMsg.getInteger("result");

        if (result == 1) {
            log.info("商品微服务操作库存成功！");
        } else {
            log.info("商品微服务操作库存失败！");
            // 进行修改订单为关闭状态
            orderService.updateStatus(orderId, 4);
        }
    }
}
