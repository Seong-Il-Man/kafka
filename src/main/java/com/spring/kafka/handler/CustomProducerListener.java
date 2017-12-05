package com.spring.kafka.handler;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;

/**
 * <p>
 */
@Component
public class CustomProducerListener implements ProducerListener<String, String>{

	@Override
	public boolean isInterestedInSuccess() {
		return false;
	}

	@Override
	public void onError(String arg0, Integer arg1, String arg2, String arg3, Exception arg4) {
		System.out.println("ERROR PRODUCER");
	}

	@Override
	public void onSuccess(String arg0, Integer arg1, String arg2, String arg3, RecordMetadata arg4) {
		System.out.println("SUCCESS PRODUCER");
	}

}
