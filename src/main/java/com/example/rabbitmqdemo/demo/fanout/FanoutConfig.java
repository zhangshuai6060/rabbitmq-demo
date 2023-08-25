package com.example.rabbitmqdemo.demo.fanout;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {


    public static final String FANOUT_QUEUE_ONE = "fanout_queue_one";

    public static final String FANOUT_QUEUE_TWO = "fanout_queue_two";

    public static final String FANOUT_EXCHANGE = "fanout_exchange";

    public static final String FANOUT_ROUTING_KEY = "fanout_test";

    @Bean
    public Queue fanoutQueueOne() {
        return new Queue(FANOUT_QUEUE_ONE, true, false, false);
    }

    @Bean
    public Queue fanoutQueueTwo() {
        return new Queue(FANOUT_QUEUE_TWO, true, false, false);
    }


    @Bean
    public Exchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE, true, false);
    }


    @Bean
    public Binding fanoutBinding(Queue fanoutQueueOne, Exchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueueOne).to(fanoutExchange).with(FANOUT_ROUTING_KEY).noargs();
    }

    @Bean
    public Binding fanoutBindingTwo(Queue fanoutQueueTwo, Exchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueueTwo).to(fanoutExchange).with(FANOUT_ROUTING_KEY).noargs();
    }

}
