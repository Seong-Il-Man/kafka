package com.spring.kafka.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Value("${kafkaTopic}")
	private String KAFKA_TOPIC;
	
	public void send(){
		kafkaTemplate.send(KAFKA_TOPIC, "Kafka Message Send Test");
	}
}
