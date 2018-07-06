package com.zlpay.feign.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.stereotype.Component;

import com.zlpay.rabbitmq.service.AbstractProducer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PayProducer extends AbstractProducer {

	public PayProducer(RabbitTemplate rabbitTemplate) {
		super(rabbitTemplate);
	}

	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		log.info("confirm: " + correlationData.getId());
    	log.info("ack: " + ack);
    	log.info("cause: " + cause);

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
