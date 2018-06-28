package com.zlpay.eurekac.app;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zlpay.common.feign.dto.PayDTO;
import com.zlpay.common.feign.dto.PayResultDTO;

@FeignClient(value = "qr-channel",fallback = QrChannelHystric.class)
public interface QrChannelAppService {
	
	@RequestMapping(value = "/aggregate/pay",method = RequestMethod.POST)
	PayResultDTO pay(@RequestBody PayDTO dto);
	
	@RequestMapping(value = "/aggregate/refund",method = RequestMethod.POST)
	String refund(@RequestParam(value="orderId") String orderId);
}
