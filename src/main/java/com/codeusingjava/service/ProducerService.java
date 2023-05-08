package com.codeusingjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.codeusingjava.model.Bid;
import com.codeusingjava.util.AppConstants;

@Service
public class ProducerService {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    

    public void send(Bid user) {
        System.out.println("Sending Bid Json Serializer : {}"+user);
        kafkaTemplate.send(AppConstants.TOPIC, user);
        kafkaTemplate.send("bid", user);
        
    }
}
