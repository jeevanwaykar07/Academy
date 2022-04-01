package com.sports.academyproject;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

@SpringBootApplication
@EnableRabbit
@ComponentScan("com.sports.academyproject.repository.AcademyRepository")
public class AcademyprojectApplication implements RabbitListenerConfigurer{
	
	

	public static void main(String[] args) {
		SpringApplication.run(AcademyprojectApplication.class, args);
	}
	 @Bean
	    public MappingJackson2MessageConverter jackson2Converter() {
	        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
	        return converter;
	    }

	    @Bean
	    public DefaultMessageHandlerMethodFactory myHandlerMethodFactory() {
	        DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
	        factory.setMessageConverter(jackson2Converter());
	        return factory;
	    }

		@Override
		public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
			registrar.setMessageHandlerMethodFactory(myHandlerMethodFactory());
			
		}

}
