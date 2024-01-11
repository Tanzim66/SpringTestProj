package com.api.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.receiver.model.Tutorial;
import com.api.receiver.repository.TutorialRepository;

@Component
public class Receiver {
	public static final String QUEUE = "rabbitmq_queue";
	
	@Autowired
	TutorialRepository tutorialRepository;
	
	@RabbitListener(queues = QUEUE)
	public void consumeMessageFromQueue(Tutorial tutorial) {
		System.out.println(tutorial.getTitle());
	}
}
