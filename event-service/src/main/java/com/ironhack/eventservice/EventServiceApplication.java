package com.ironhack.eventservice;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
@EnableEurekaClient
public class EventServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventServiceApplication.class, args);
	}

	@Bean
	public NewTopic topic() {
		return TopicBuilder.name("events")
				.partitions(2)
				.replicas(1)
				.build();
	}


	@KafkaListener(topics = "events", groupId = "foo", containerFactory = "kafkaListenerContainerFactory")
	public void listenFooGroup(String message){
		System.out.println("mensaje recibido: " + message);
	}
}
