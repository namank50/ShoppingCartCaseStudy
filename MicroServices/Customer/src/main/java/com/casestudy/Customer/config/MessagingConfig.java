package com.casestudy.Customer.config;

import org.springframework.amqp.core.AmqpTemplate;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MessagingConfig {
	
	public static final String Queue="queue_dealer";
	public static final String Exchange="exchange_dealer";
	public static final String Routing="dealer_routing";

	@Bean
	public Queue queue() {
		return new Queue(Queue);
	}
	
	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(Exchange);
	}
	
	@Bean
	public Binding binding(Queue queue,TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(Routing);
	}
	
	@Bean
	public MessageConverter convertor() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	public AmqpTemplate template(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(convertor());
		return rabbitTemplate;
		
	}
	
	

}
