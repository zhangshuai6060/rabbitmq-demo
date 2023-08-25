package com.example.rabbitmqdemo.demo.topic;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class TopicListener {
    @RabbitListener(queues = TopicConfig.TOPIC_QUEUE)
    public void consume(String msg, Channel channel, Message message) throws IOException {
        System.out.println("这是主题消息测试：" + msg);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
