package com.spring.kafka.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
	private static final Logger logger = LogManager.getLogger(MessageListener.class);
	
	@KafkaListener(id = "listener", topics = "${kafkaTopic}", containerFactory = "kafkaListenerContainerFactory")
	public void listen(ConsumerRecord<String, String> data, Acknowledgment ack) {
		
		long offset = data.offset();
		int partition = data.partition();
		String message = data.value();
		
		logger.info("[Consume Message] partition-[" + partition + "], offset-[" + offset + "], message-[" + message + "]");
		
	    ack.acknowledge();
	}
}
