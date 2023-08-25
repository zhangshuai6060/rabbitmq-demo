package com.example.rabbitmqdemo.demo.direct;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectConfig {


    public static final String DIRECT_QUEUE = "direct_queue";


    @Bean
    public Queue directQueue() {
        return new Queue(DIRECT_QUEUE, true, false, false);
    }


}
