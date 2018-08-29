package com.zlpay.feign.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zlpay.feign.rabbitmq.PayProducer;
import com.zlpay.rabbitmq.constant.TopicRoutingKeyConstant;
import com.zlpay.rabbitmq.enums.ExchangeEnum;

@RefreshScope
@RestController
public class RabbitmqController {
	
	@Autowired
    private PayProducer producer;
 
    @GetMapping("/send")
    public String send(String msg) {
    	for(int i = 1;i < 10; i++) {
    		producer.send(ExchangeEnum.PAY_TOPIC_EXCHANGE, TopicRoutingKeyConstant.PAY_TOPIC, "消息" + i, UUID.randomUUID().toString());
    	}
        return "Send OK.";
    }
}
