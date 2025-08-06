package com.enduser;


import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConfig {

    @KafkaListener(topics = Appconstants.LOCATION_UPDATE_TOPIC, groupId = "group-1")
    public void updatedLocation1(String value) {
        System.out.println("Consumer 1 received: " + value);
    }

    @KafkaListener(topics = "location-update-topic", groupId = "group-1")
    public void consumer2(String message) {
        System.out.println("C2 received: " + message);
    }

//    @KafkaListener(topics = Appconstants.LOCATION_UPDATE_TOPIC, groupId = "group-3")
//    public void updatedLocation3(String value) {
//        System.out.println("Consumer 3 received: " + value);
//    }
//    @KafkaListener(topics = Appconstants.LOCATION_UPDATE_TOPIC, groupId = "group-4")
//    public void updatedLocation4(String value) {
//        System.out.println("Consumer 4 received: " + value);
//    }

}
