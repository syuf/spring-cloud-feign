package com.zlpay.feign.service;

import com.zlpay.common.feign.dto.PayDTO;
import com.zlpay.common.feign.dto.PayResultDTO;

public interface PayService {

	/**
	* @Description: 支付  
	* @param payDto
	* @return PayResultDTO
	* @throws  
	* @author: syuf
	* @date: 2018年6月28日 上午11:26:04
	 */
	PayResultDTO pay(PayDTO payDto);

	String refund(String orderId);
	
}
