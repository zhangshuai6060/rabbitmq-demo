package com.example.rabbitmqdemo.util;

import com.example.rabbitmqdemo.config.RabbitMQConfig;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


public class RabbitMQConnectionUtil {


    /**
     * 构建RabbitMQ的连接对象
     *
     * @return
     */
    public static Connection getConnection() throws Exception {
        //1. 创建Connection工厂
        ConnectionFactory factory = new ConnectionFactory();

        //2. 设置RabbitMQ的连接信息
        factory.setHost(RabbitMQConfig.getHost());
        factory.setPort(RabbitMQConfig.getPort());
        factory.setUsername(RabbitMQConfig.getUsername());
        factory.setPassword(RabbitMQConfig.getPassword());
        factory.setVirtualHost(RabbitMQConfig.getVirtualHost());

        //3. 返回连接对象
        Connection connection = factory.newConnection();
        return connection;
    }

}
