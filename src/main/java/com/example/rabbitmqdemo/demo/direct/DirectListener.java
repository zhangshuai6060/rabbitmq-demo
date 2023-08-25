package com.example.rabbitmqdemo.demo.direct;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class DirectListener {

    @RabbitListener(queues = DirectConfig.DIRECT_QUEUE)
    public void consume(String msg, Channel channel, Message message) throws IOException {
        System.out.println("队列的消息为：" + msg);

        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }

}
