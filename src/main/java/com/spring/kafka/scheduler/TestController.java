package com.spring.kafka.scheduler;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {
	private static final Logger logger = LogManager.getLogger(TestController.class);
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Scheduled(fixedDelay = 5000)
	public void test(){
		logger.info("AADASDASDASDA");
		kafkaTemplate.send("TEST", "TEST");
	}
}
