package com.spring.kafka.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
	
	@KafkaListener(id = "listener", topics = "${kafkaTopic}", containerFactory = "kafkaListenerContainerFactory")
	public void listen(String data, Acknowledgment ack) {
		System.out.println(data);
		
	    ack.acknowledge();
	}
}
