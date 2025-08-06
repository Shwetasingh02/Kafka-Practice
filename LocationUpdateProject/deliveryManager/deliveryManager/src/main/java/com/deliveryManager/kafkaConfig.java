package com.deliveryManager;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class kafkaConfig {


    @KafkaListener(topics = "location-update-topic")
    public void consumeDeliveryManager(String message) {
        System.out.println("DeliveryManager received: " + message);
    }

    @KafkaListener(topics = "location-update-topic")
    public void consumeDeliveryManager2(String message) {
        System.out.println("D2: " + message);
    }
}
