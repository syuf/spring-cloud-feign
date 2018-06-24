package com.zlpay.eurekac.app;

import org.springframework.stereotype.Component;

@Component
public class HiServiceHystric implements HiAppService {

	@Override
	public String sayHiFromClientOne(String name) {
		 return "sorry "+name;
	}

}
