package com.kafka.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.model.model;

@RestController
@RequestMapping("kafka")
public class resource {

@Autowired
public KafkaTemplate<String, model> KafkaTemplate; 

public static final String TOPIC="Kafka_Example";
	
	@GetMapping("/publish/{name}")
	public String post(@PathVariable("name") final String name)
	{

		KafkaTemplate.send(TOPIC,new model(11,name,"Delhi"));
		return "PUBLISHED SUCCESSFULLY!!!";

	}	


}
