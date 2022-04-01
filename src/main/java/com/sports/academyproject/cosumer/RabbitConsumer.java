package com.sports.academyproject.cosumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sports.academyproject.repository.AcademyRepository;
import com.sprorts.academyproject.entity.Student;

/*
 * @Service public class RabbitConsumer {
 * 
 * @Autowired(required=true) AcademyRepository repository;
 * 
 * @RabbitListener(queues = "${rabbitmq.queue}") public void
 * recievedMessage(Student student) {
 * 
 * repository.save(student);
 * System.out.println("Recieved Message From RabbitMQ: " + student); }
 * 
 * 
 * }
 */
@Component
public class RabbitConsumer {
	
	@Autowired
	AcademyRepository repository;

	@RabbitListener(queues = "${rabbitmq.queue}")
	public void recievedMessage(Student stusub) {
		
		repository.save(stusub);
		System.out.println("Recieved Message From RabbitMQ: " + stusub);
	}
}