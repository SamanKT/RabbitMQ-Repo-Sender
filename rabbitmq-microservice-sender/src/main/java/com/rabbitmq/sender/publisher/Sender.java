package com.rabbitmq.sender.publisher;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.sender.message.MyMessage;

@RestController
public class Sender {
	
	@Autowired
	private RabbitTemplate template;
	
	@Autowired
	private DirectExchange exchange;
	
	@PostMapping("/post")
	public String sending(@RequestBody MyMessage message) {
		
		template.convertAndSend(exchange.getName(), "Q1", message);
		
		return "the message is published";
	}

}
