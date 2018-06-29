package com.zlpay.eurekac.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zlpay.common.constant.QueueConstants;

@Component
public class Producer {
	@Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String context){

        this.rabbitTemplate.convertAndSend(QueueConstants.EMAIL,context);

    }
}
