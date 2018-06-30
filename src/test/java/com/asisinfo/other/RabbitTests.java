package com.asisinfo.other;

import com.asisinfo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * rabbit测试
 * webUi端口:15672    默认账号密码：guest
 * rabbitTemplate基础api测试，实际开发中用的是监听
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void amqpAdminTest(){
        Exchange exchange = new DirectExchange("amqpAdmin.exchange");
        amqpAdmin.declareExchange(exchange);
//        System.out.println("创建exchange成功");
//
//        amqpAdmin.declareQueue(new Queue("amqpAdmin.queue",true));
//        System.out.println("创建queue成功");

//        Binding binding = new Binding("amqpAdmin.queue",
//                Binding.DestinationType.QUEUE,"amqpAdmin.exchange","amqp.queue.key",null);
//        amqpAdmin.declareBinding(binding);
//        System.out.println("绑定成功");
    }

    /**
     * 1.单播（点对点）
     */
    @Test
    public void sendMsgOneToOne(){
        //Message需要自己构造一个，定制消息体内容和消息头
        //rabbitTemplate.send(exchage,routeKey,message);
        //只需要传入要发送的对象，自动序列化发送给rabbitmq
        //rabbitTemplate.convertAndSend(exchage,routeKey,object);
        //对象被默认序列化以后发送出去
        Map<String,String> map = new HashMap<>();
        map.put("duyubo","shuai");
        map.put("ct","高高的");
        rabbitTemplate.convertAndSend("amq.direct","duyubo2",map);
    }

    /**
     * 接收消息
     */
    @Test
    public void receiveMsgOneToOne(){
        Object msg = rabbitTemplate.receiveAndConvert("duyubo");
        System.out.println(msg);
    }

    /**
     * 2.广播（点对多）
     */
    @Test
    public void sendMsgOneToMany(){
        Map<String,String> map = new HashMap<>();
        map.put("duyubo","shuai");
        map.put("ct","高高的");
        rabbitTemplate.convertAndSend("amq.fanout","",map);
    }
}
