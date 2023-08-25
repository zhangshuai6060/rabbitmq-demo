package com.example.rabbitmqdemo.demo.topic;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfig {

    public static final String TOPIC_QUEUE = "topic_queue";

    public static final String TOPIC_EXCHANGE = "topic_exchange";

    public static final String TOPIC_ROUTING_KEY = "topic.#";


    @Bean
    public Queue topicQueue() {
        return new Queue(TOPIC_QUEUE, true, false, false);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE, true, false);
    }

    @Bean
    public Binding topicBinding(Queue topicQueue, Exchange topicExchange) {
        return BindingBuilder.bind(topicQueue).to(topicExchange).with(TOPIC_ROUTING_KEY).noargs();
    }
}
