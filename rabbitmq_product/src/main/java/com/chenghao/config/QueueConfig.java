package com.chenghao.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 队列配置类
 * @author chenghao
 * @date 2019/9/7
 */
@Configuration
public class QueueConfig {
    /**
     * 测试队列名称
     */
    private static final String TEST_QUEUE = "test";

    /**
     * 用于和测试交换机绑定
     * 第一个参数表示队列名称，第二个参数表示是否持久化
     */
    @Bean
    public Queue testQueue(){
        return new Queue(TEST_QUEUE,true);
    }
}
