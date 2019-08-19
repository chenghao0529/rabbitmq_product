package com.chenghao.product;

import com.chenghao.domain.Person;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by 程昊 on 2019/8/19.
 */
@Component
public class Send  {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {
        @Override
        /**
         * CorrelationData 消息的附加信息，即自定义id
         * isack 代表消息是否被rabbitmq接收 true 代表接收 false代表拒收。
         * cause 如果拒收cause则说明拒收的原因，帮助我们进行后续处理
         */
        public void confirm(CorrelationData correlationData, boolean isack, String cause) {
            System.out.println(correlationData);
            System.out.println("ack:" + isack);
            if (!isack) {
                System.err.println(cause);
            }
        }
    };
    //debug启动测试类吧，run启动经常不执行
    RabbitTemplate.ReturnCallback returnCallback = new RabbitTemplate.ReturnCallback() {
        @Override
        public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingkey) {
            System.err.println("Code:" + replyCode + ",Text:" + replyText );
            System.err.println("Exchange:" + exchange + ",RoutingKey:" + routingkey );
        }
    };

    //发送消息
    public void sendMsg(Person person){
        ////CorrelationData对象的作用是作为消息的附加信息传递，我们用它来保存消息的自定义id
        CorrelationData correlationData = new CorrelationData(person.getUsername() + "" + new Date().getTime());
        rabbitTemplate.setConfirmCallback(confirmCallback);
        rabbitTemplate.setReturnCallback(returnCallback);
        rabbitTemplate.convertAndSend("rabbitmq-test","kewenjia",person,correlationData);
    }
}
