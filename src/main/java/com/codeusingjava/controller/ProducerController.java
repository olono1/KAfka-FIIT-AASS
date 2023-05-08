package com.codeusingjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codeusingjava.model.Bid;
import com.codeusingjava.service.ProducerService;

@RestController
@RequestMapping(value = "/kafka/")
public class ProducerController {

    @Autowired
    ProducerService kafkaProducer;


    @PostMapping(value = "/producer")
    public String sendMessage(@RequestBody Bid user)
    {
    	System.out.println("Producer Controller is Good:26");
        kafkaProducer.send(user);
        return "Message sent Successfully to the topic";
    }

}
