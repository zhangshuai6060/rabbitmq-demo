package com.example.rabbitmqdemo.demo.fanout;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FanoutPublish {

    private final RabbitTemplate rabbitTemplate;

    public void publish() {
        String message = "这是fanout类型的消息";
        rabbitTemplate.convertAndSend(FanoutConfig.FANOUT_EXCHANGE, FanoutConfig.FANOUT_ROUTING_KEY, message);
    }

}
