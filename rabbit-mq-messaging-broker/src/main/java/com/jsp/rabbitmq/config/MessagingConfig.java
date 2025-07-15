package com.jsp.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig 
{

	@Bean
	public TopicExchange exchange()
	{
		return new TopicExchange("RabbitMQ messaging broker_exchange");
	}
	
	@Bean
	public Queue queue() 
	{
		return new Queue("RabbitMQ messaging broker_Queue");
	}
	
	
	public Binding binding(Queue queue,TopicExchange exchange) 
	{
		return BindingBuilder.bind(queue).to(exchange).with("messagingBroker-rabbitmq");
	}
}
