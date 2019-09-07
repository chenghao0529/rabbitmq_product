package com.chenghao.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 交换机配置类
 * @author chenghao
 * @date 2019/9/7
 */
@Configuration
public class ExchangeConfig {
    /**
     * 用于测试的交换机
     */
    public static final String TEST_EXCHANGE = "test";

    /**
     * 用与测试的交换机
     * 第一个参数交换机名称，第二个参数是否持久化，第三个参数是否自动删除
     * @return
     */
    @Bean
    public  DirectExchange testExchange(){
        return new DirectExchange(TEST_EXCHANGE,true,false);
    }
}
