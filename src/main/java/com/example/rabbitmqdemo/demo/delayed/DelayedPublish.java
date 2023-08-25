package com.example.rabbitmqdemo.demo.delayed;

import lombok.AllArgsConstructor;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DelayedPublish {

    private final RabbitTemplate rabbitTemplate;

    public void publish() {
        String orderId = "10010123456";
        rabbitTemplate.convertAndSend(DelayedConfig.DELAYED_EXCHANGE, "delayed.abc", "这是测试消息", new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                //设置消息持久化操作
                message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                message.getMessageProperties().setCorrelationId(orderId);
                message.getMessageProperties().setDelay(30000);
                return message;
            }
        });
    }

}
