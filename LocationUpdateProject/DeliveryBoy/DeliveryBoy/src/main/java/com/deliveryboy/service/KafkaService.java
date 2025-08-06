package com.deliveryboy.service;

import com.deliveryboy.config.AppConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final Logger logger = LoggerFactory.getLogger(KafkaService.class);

    public boolean updateLocation(String location) {
        try {
            kafkaTemplate.send(AppConstant.LOCATION_TOPIC_NAME, location).get(); // waits for result
            logger.info("Message sent successfully: {}", location);
            return true;
        } catch (Exception e) {
            logger.error("Error sending Kafka message: {}", location, e);
            return false;
        }
    }
}
