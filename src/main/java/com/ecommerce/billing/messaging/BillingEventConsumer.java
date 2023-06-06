package com.ecommerce.billing.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class BillingEventConsumer {
	private static Logger LOGGER = LoggerFactory.getLogger(BillingEventConsumer.class);

	@KafkaListener(topics = "orderTopic", 
			groupId = "group-id")
	public void consume(String product) 
	{
		LOGGER.info(String.format("Order created -> %s", product));
	}
}
