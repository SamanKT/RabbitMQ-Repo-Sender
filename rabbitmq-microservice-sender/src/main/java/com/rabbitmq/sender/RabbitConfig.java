package com.rabbitmq.sender;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
	
	@Value("${queue.name.one}")
	private String queueName1;
	
	@Value("${queue.name.two}")
	private String queueName2;
	
	@Bean
	public Queue queue1() {
		return new Queue(queueName1);
	}
	
	@Bean
	public Queue queue2() {
		return new Queue(queueName2);
	}
	
	
	@Bean
	DirectExchange exchange() {
		return new DirectExchange("direct.exchange");
	}
	
	@Bean
	Binding binding(Queue queue1, DirectExchange exchange) {
		
		return BindingBuilder.bind(queue1).to(exchange).with("Q1");
		
	}
	
	@Bean
	Binding binding2(Queue queue2, DirectExchange exchange) {
		
		return BindingBuilder.bind(queue2).to(exchange).with("Q2");
		
	}
	
	@Bean
	MessageConverter converter() {
		
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	RabbitTemplate template(ConnectionFactory factory) {
		
		RabbitTemplate template = new RabbitTemplate(factory);
		
		template.setMessageConverter(converter());;
		return template;
	}
}
