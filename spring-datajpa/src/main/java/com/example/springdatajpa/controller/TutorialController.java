package com.example.springdatajpa.controller;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdatajpa.config.MessagingConfig;
import com.example.springdatajpa.model.Tutorial;
import com.example.springdatajpa.repository.TutorialRepository;

//configures allowed origins
@CrossOrigin(origins = "http://localhost:8081")
//Defines a controller to indicates the return value of the methods is bound to web response body
@RestController
//Declares that all apis' url in the controller start with /api
@RequestMapping("/api")
public class TutorialController {

	//inject repository bean to local variable
	@Autowired
	TutorialRepository tutorialRepository;
	
	@Autowired
	RabbitTemplate template;
	
	  @PostMapping("/tutorials")
	  public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
	    try {
	    	
	    	template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, tutorial);
	    	
	     // Tutorial _tutorial = tutorialRepository
	      //    .save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), false));
	      return new ResponseEntity<>(HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
}
