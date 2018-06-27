package com.zlpay.eurekac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zlpay.eurekac.app.HiAppService;

@RestController
public class PayController {

	@Value("${username}")
    String content;
	
	@Autowired
	HiAppService schedualServiceHi;
	
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        return schedualServiceHi.sayHiFromClientOne(name);
    }
    
    @RequestMapping(value = "/read",method = RequestMethod.GET)
    public String read(){
        return content;
    }
}
