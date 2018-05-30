package com.example.mq.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @author QuiFar
 * @version V1.0
 **/
@Component
@Slf4j
public class MqProducer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    /**
     * 发送消息
     * TODO 先不考虑发送失败情况
     *
     * @param topic 主题
     * @param msg   消息内容
     */
    public void send(String topic, Object msg) {

        log.info(">>>>>>>>>>--------------发送消息开始-------------------->>>>>>");
        ListenableFuture<SendResult<String, Object>> send = kafkaTemplate.send(topic, msg);

        send.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            // SendResult 包括了 producerRecord 和 RecordMetadata
            @Override
            public void onSuccess(SendResult<String, Object> result) {
                //成功业务逻辑
                System.err.println("发送消息成功:" + msg);
            }

            @Override
            public void onFailure(Throwable ex) {
                //失败业务逻辑
                System.err.println("发送消息失败:" + ex.getMessage());
            }
        });
    }

    /**
     * 创建订单是发送mq消息
     * topic=createOrder
     *
     * @param msg 消息
     */
    public void sendMq4CreateOder(String msg) {
        this.send("createOrder", msg);
    }

    /**
     * 更新商品销量和库存是发送mq消息
     * topic=handleGoodsStockAndSaleCount
     *
     * @param msg 消息
     */
    public void sendMq4GoodsStockAndSaleCount(String msg) {
        this.send("handleGoodsStockAndSaleCount", msg);
    }
}
