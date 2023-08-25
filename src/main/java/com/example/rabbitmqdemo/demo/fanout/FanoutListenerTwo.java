package com.example.rabbitmqdemo.demo.fanout;

import com.example.rabbitmqdemo.demo.direct.DirectConfig;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class FanoutListenerTwo {

    @RabbitListener(queues = FanoutConfig.FANOUT_QUEUE_TWO)
    public void consume(String msg, Channel channel, Message message) throws IOException {
        System.out.println("这是广播2获取到的消息为：" + msg);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }

}
