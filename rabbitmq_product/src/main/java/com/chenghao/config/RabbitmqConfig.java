package com.chenghao.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * 设定路由键绑定交换机和队列
 * @author chenghao
 * @date 2019/9/7
 */
@Configuration
public class RabbitmqConfig {

    @Resource
    private QueueConfig queueConfig;
    @Resource
    private ExchangeConfig exchangeConfig;

    public static final String TEST_ROUTINGKEY = "test";

    /**
     * 绑定test交换机和test队列,路由键test
     * @return
     */
    @Bean
    public Binding bing_test(){
        return BindingBuilder.bind(queueConfig.testQueue())
                .to(exchangeConfig.testExchange())
                .with(TEST_ROUTINGKEY);
    }

}
