package com.spring.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

/**
 * <p> KafkaConfig
 */
@Configuration
@EnableKafka
public class KafkaConfig {
	
	@Value("${bootstrap.servers.config}")
	private String bootstrapServersConfig;
	
	@Value("${enable.auto.commit.config}")
	private String enableAutoCommitConfig;
	
	@Value("${session.timeout.ms.config}")
	private String sessionTimeoutMsConfig;
	
	@Value("${key.deserializer.class.config}")
	private String keyDeserializerClassConfig;
	
	@Value("${value.deserializer.class.config}")
	private String valueDeserializerClassConfig;
	
	@Value("${group.id.config}")
	private String groupIdConfig;
	
	@Value("${auto.offset.reset.config}")
	private String autoOffsetResetConfig;
	
	@Bean
    KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setConcurrency(3);
        factory.getContainerProperties().setPollTimeout(3000);
        return factory;
    }
	
	@Bean
    public ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }
	
	@Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServersConfig);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, enableAutoCommitConfig);
//		props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, sessionTimeoutMsConfig);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, keyDeserializerClassConfig);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, valueDeserializerClassConfig);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupIdConfig);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetResetConfig);
        return props;
    }
}
