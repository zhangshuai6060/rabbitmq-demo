package com.example.rabbitmqdemo.demo.topic;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TopicPublish {

    private final RabbitTemplate rabbitTemplate;

    public void publish(String routingKey) {
        String message = "这是topic类型消息";
        rabbitTemplate.convertAndSend(TopicConfig.TOPIC_EXCHANGE, routingKey, message);
    }

}
