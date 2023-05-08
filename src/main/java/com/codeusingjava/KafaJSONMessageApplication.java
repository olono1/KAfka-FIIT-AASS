package com.codeusingjava;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;

import com.codeusingjava.model.Bid;
import com.codeusingjava.util.AppConstants;

@SpringBootApplication
public class KafaJSONMessageApplication {

	public static void main(String[] args) {
        SpringApplication.run(KafaJSONMessageApplication.class, args);
    }
	
	public NewTopic auctionTopic() {
	    return TopicBuilder.name("auction")
	            .build();
	}
	
	public NewTopic invoiceTopic() {
	    return TopicBuilder.name("invoice")
	            .build();
	}
	
	public NewTopic bidTopic() {
	    return TopicBuilder.name("bid")
	            .build();
	}

	@KafkaListener(topics = AppConstants.TOPIC, groupId=AppConstants.GROUP_ID)
    public void listen(Bid user) {

        System.out.println("Received info--> : " +user);
    }
	
	
	
	
}
