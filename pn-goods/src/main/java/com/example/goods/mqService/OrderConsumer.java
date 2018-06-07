package com.example.goods.mqService;

import com.alibaba.fastjson.JSONObject;
import com.example.goods.service.GoodsService;
import com.example.mq.service.MqProducer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 订单消费者
 *
 * @author QuiFar
 * @version V1.0
 **/
@Component
public class OrderConsumer {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private MqProducer mqProducer;

    @KafkaListener(topics = {"createOrder"})
    public void processOrderMsg(ConsumerRecord<?, ?> data) {
        JSONObject order = JSONObject.parseObject((String) data.value());
        System.err.println("接受到订单消息:" + order.get("goodsName"));

        // 操作库存
        int goodsId = order.getInteger("goodsId");
        int amount = order.getInteger("amount");
        int flag = goodsService.update(goodsId, amount);

        // 确保最终一致
        JSONObject msg = new JSONObject();
        msg.put("goodsId", goodsId);
        msg.put("result", "1");
        if (flag <= 0) {
            msg.put("result", "0");
        }

        mqProducer.sendMq4GoodsStockAndSaleCount(msg.toJSONString());
    }
}
