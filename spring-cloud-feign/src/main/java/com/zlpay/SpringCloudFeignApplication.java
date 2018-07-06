package com.zlpay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
@SpringBootApplication
public class SpringCloudFeignApplication {
    
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFeignApplication.class, args);
	}
	
	@Bean
	public ServletRegistrationBean<HystrixMetricsStreamServlet> getServlet(){

	   HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();

	   ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<HystrixMetricsStreamServlet>(streamServlet);

	   registrationBean.setLoadOnStartup(1);

	   registrationBean.addUrlMappings("/actuator/hystrix.stream");

	   registrationBean.setName("HystrixMetricsStreamServlet");


	   return registrationBean;
	}
}
