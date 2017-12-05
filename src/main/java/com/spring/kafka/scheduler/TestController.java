package com.spring.kafka.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Scheduled(fixedDelay = 5000)
	public void test(){
		kafkaTemplate.send("TEST", "TEST");
	}
}
