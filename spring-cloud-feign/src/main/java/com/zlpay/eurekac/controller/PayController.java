package com.zlpay.eurekac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zlpay.common.feign.dto.PayDTO;
import com.zlpay.common.feign.dto.PayResultDTO;
import com.zlpay.eurekac.service.PayService;

@RestController
public class PayController {

	@Value("${username}")
    private String userName;
	
	@Autowired
	PayService payService;
	
    @RequestMapping(value = "/pay",method = RequestMethod.GET)
    public PayResultDTO pay(){
    	PayDTO payDto = new PayDTO();
    	payDto.setOrderId("1111");
    	payDto.setAmt(200);
        return payService.pay(payDto);
    }
    
    @RequestMapping(value = "/refund",method = RequestMethod.GET)
    public String refund(String orderId){
        return payService.refund(orderId);
    }
    
    @RequestMapping(value = "/readUserName",method = RequestMethod.GET)
    public String read(){
        return userName;
    }
}
