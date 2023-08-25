package com.example.rabbitmqdemo;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class RabbitmqDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqDemoApplication.class, args);
    }


    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        // 设置 confirm ConfirmCallback
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            if (ack) {
                log.warn("消息已经送达到交换机！！{}", correlationData.getId());
            } else {
                System.out.println("消息没有送达到Exchange，需要做一些补偿操作！！retry！！！");
            }
        });
        //设置 return
        rabbitTemplate.setReturnsCallback((returnedMessage) -> {
            String msg = new String(returnedMessage.getMessage().getBody());
            System.out.println("消息：" + msg + "路由队列失败！！做补救操作！！");
        });
        return rabbitTemplate;
    }
}
