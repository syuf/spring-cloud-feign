package com.zlpay.feign.rabbitmq;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zlpay.rabbitmq.enums.ExchangeEnum;
import com.zlpay.rabbitmq.service.AbstractProducer;
import com.zlpay.redis.client.RedisClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PayProducer extends AbstractProducer {
	
	@Autowired
	private RedisClient redisClient;

	public PayProducer(RabbitTemplate rabbitTemplate) {
		super(rabbitTemplate);
	}
	

	@Override
	public void send(ExchangeEnum exchange, String routingKey,String msg,String msgId) {
        CorrelationData correlationData = new CorrelationData(msgId);
        redisClient.set(msgId, msg);
        try {
			this.rabbitTemplate.convertAndSend(exchange.getValue(), routingKey, msg, correlationData);
		} catch (AmqpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		log.info("confirm: " + correlationData.getId());
    	log.info("ack: " + ack);
    	log.info("cause: " + cause);
    	if(!ack) {
    		redisClient.remove(correlationData.getId());
    	}
	}

	@Override
	public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
		log.info("message: " + message.getBody());
    	log.info("replyCode: " + replyCode);
    	log.info("replyText: " + replyText);
    	log.info("exchange: " + exchange);
    	log.info("routingKey: " + routingKey);

	}

}
