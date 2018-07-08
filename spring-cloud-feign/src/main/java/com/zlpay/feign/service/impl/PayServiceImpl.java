package com.zlpay.feign.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zlpay.common.app.ProviderAppService;
import com.zlpay.common.feign.dto.PayDTO;
import com.zlpay.common.feign.dto.PayResultDTO;
import com.zlpay.feign.service.PayService;

@Service("payService")
public class PayServiceImpl implements PayService {

	@Autowired
	private ProviderAppService providerService;
	
	@Override
	public PayResultDTO pay(PayDTO dto) {
		return providerService.pay(dto);
	}

	@Override
	public String refund(String orderId) {
		return providerService.refund(orderId);
	}

}
