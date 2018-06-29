package com.zlpay.eurekac.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zlpay.common.feign.dto.PayDTO;
import com.zlpay.common.feign.dto.PayResultDTO;
import com.zlpay.eurekac.app.QrChannelAppService;
import com.zlpay.eurekac.rabbitmq.Producer;
import com.zlpay.eurekac.service.PayService;

@Service("payService")
public class PayServiceImpl implements PayService {

	@Autowired
	private QrChannelAppService qrChannelAppService;
	@Autowired
	private Producer producer;
	
	@Override
	public PayResultDTO pay(PayDTO dto) {
		producer.send("请向调用qr-channel的hi接口");
		return qrChannelAppService.pay(dto);
	}

	@Override
	public String refund(String orderId) {
		return qrChannelAppService.refund(orderId);
	}

}
