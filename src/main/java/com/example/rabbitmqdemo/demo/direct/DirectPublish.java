package com.example.rabbitmqdemo.demo.direct;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DirectPublish {

    private final RabbitTemplate rabbitTemplate;

    public void publish() {
        String message = "测试direct模式发送消息";
        //CorrelationData :是为了 使用 confirm ,如果消息到不了 broker可以在 确认消息里面进行补偿
        CorrelationData correlationData = new CorrelationData();
        // 这是测试消息
        correlationData.setId("test001:" + message);
        // 如果不指定交换机 那么就使用默认的交换机 rabiitMQ中 默认的交换机 也是 Direct 类型
        rabbitTemplate.convertAndSend("", DirectConfig.DIRECT_QUEUE, message, correlationData);
    }

}
