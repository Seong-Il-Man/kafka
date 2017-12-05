package com.spring.kafka.listener;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
	private static final Logger logger = LogManager.getLogger(MessageListener.class);
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
//	@KafkaListener(id = "listener", topics = "${kafkaTopic}", containerFactory = "kafkaListenerContainerFactory")
	public void listen(String data, Acknowledgment ack) {
		
		kafkaTemplate.send("T", "AAA");
		System.out.println(data);
		
	    ack.acknowledge();
	}
}
