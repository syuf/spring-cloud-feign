package com.zlpay.feign.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zlpay.redis.client.RedisClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class RedisController {
	
	@Autowired
	private RedisClient redisClient;
	
	@RequestMapping("put")
	public String put(String number ) {
		Map<String, String> value = new HashMap<>();
		value.put(number, number);
		redisClient.set(number, "哈哈哈哈啊哈哈");
		return number;
	}
	
	@RequestMapping("query")
	public String query(String number ) {
		String value = redisClient.get(number);
		log.info(value);
		return number;
	}
	
}
