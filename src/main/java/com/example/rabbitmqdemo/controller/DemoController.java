package com.example.rabbitmqdemo.controller;

import com.example.rabbitmqdemo.demo.delayed.DelayedPublish;
import com.example.rabbitmqdemo.demo.direct.DirectPublish;
import com.example.rabbitmqdemo.demo.fanout.FanoutPublish;
import com.example.rabbitmqdemo.demo.topic.TopicPublish;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class DemoController {

    /**
     * 延迟消息推送
     */
    private final DelayedPublish delayedPublish;

    /**
     * 广播消息推送
     */
    private final FanoutPublish fanoutPublish;

    /**
     * 普通消息推送
     */
    private final DirectPublish directPublish;

    /**
     * 主题消息测试
     */
    private final TopicPublish topicPublish;

    @GetMapping("pushDirectMessage")
    public String pushDirectMessage() {
        directPublish.publish();
        return "发送成功";
    }


    /**
     * 发送延迟任务消息
     *
     * @return
     */
    @GetMapping("pushDelayedMessage")
    public String pushDelayedMessage() {
        delayedPublish.publish();
        return "发送成功";
    }


    /**
     * 发送广播消息
     *
     * @return
     */
    @GetMapping("pushFanoutMessage")
    public String pushFanoutMessage() {
        fanoutPublish.publish();
        return "发送成功";
    }


    /**
     * 主题消息测试
     *
     * @return
     */
    @GetMapping("pushTopicMessage")
    public String pushTopicMessage(String routingKey) {
        topicPublish.publish(routingKey);
        return "发送成功";
    }


}
