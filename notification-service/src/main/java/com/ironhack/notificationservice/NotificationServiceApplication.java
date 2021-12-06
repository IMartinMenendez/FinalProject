package com.ironhack.notificationservice;

import com.ironhack.common.dto.event.EventKafka;
import com.ironhack.notificationservice.services.NotificationService;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
@EnableEurekaClient
public class NotificationServiceApplication {

	@Autowired
	private NotificationService notificationService;

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}

	@Bean
	public NewTopic topic() {
		return TopicBuilder.name("events")
				.partitions(2)
				.replicas(1)
				.build();
	}


	@KafkaListener(topics = "events")
	public void listenFooGroup(EventKafka message){
		notificationService.messageKafka(message);
		System.out.println("mensaje recibido: " + message);
	}

}
