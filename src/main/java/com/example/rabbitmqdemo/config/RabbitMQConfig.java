package com.example.rabbitmqdemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.rabbitmq")
public class RabbitMQConfig {

    private static String host;
    private static int port;
    private static String username;
    private static String password;
    private static String virtualHost;


    public static String getHost() {
        return host;
    }

    public void setHost(String host) {
        RabbitMQConfig.host = host;
    }

    public static int getPort() {
        return port;
    }

    public void setPort(int port) {
        RabbitMQConfig.port = port;
    }

    public static String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        RabbitMQConfig.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        RabbitMQConfig.password = password;
    }

    public static String getVirtualHost() {
        return virtualHost;
    }

    public void setVirtualHost(String virtualHost) {
        RabbitMQConfig.virtualHost = virtualHost;
    }
}
