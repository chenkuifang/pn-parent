package com.example.mq.service;

import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 接收消息可通过配置MessageListenerContainer bean 或使用注解@KafkaListener
 * 1.提供消息监听的接口有4个，分别为：MessageListener，AcknowledgingMessageListener，
 * BatchMessageListener，BatchAcknowledgingMessageListener
 *
 * @author QuiFar
 * @version V1.0
 **/
@Component
public class MqConsumer {

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    /**
     * 处理消息
     * ConsumerRecord 包含
     * <p>
     * private final String topic;
     * private final int partition;
     * private final long offset;
     * private final long timestamp;
     * private final TimestampType timestampType;
     * private final long checksum;
     * private final int serializedKeySize;
     * private final int serializedValueSize;
     * private final K key;
     * private final V value;
     *
     * @param data 接收消息体
     * @param ack  通知回调，消费完成，提交offset
     */
    @KafkaListener(topics = {"test", "test2"})
    public void processMessage(ConsumerRecord<?, ?> data) {
        System.err.println("接收到信息： " + data.value());

        // 手动提交offset, 需要配置 ack-mode: manual_immediate
        //ack.acknowledge();

        // stop
        //latch.countDown();
    }

    /*@KafkaListener(topics = {"createOrder"})
    public void processOrderMsg(ConsumerRecord<?, Order> data) {
        System.err.println("接受到订单消息:" + data.toString());
    }*/
}
