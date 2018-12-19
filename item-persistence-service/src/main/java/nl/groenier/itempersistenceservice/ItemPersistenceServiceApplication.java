package nl.groenier.itempersistenceservice;

import nl.groenier.itempersistenceservice.controllers.ItemController;
import org.springframework.amqp.core.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ItemPersistenceServiceApplication {

	@Bean
	public Declarables qs() {
		Queue itemCreatedQueue = new Queue("item-created-queue", false);
		Queue itemReadQueue = new Queue("item-read-queue", false);
		Queue itemUpdatedQueue = new Queue("item-updated-queue", false);
		Queue itemDeletedQueue = new Queue("item-deleted-queue", false);

		return new Declarables(
				itemCreatedQueue,
				itemReadQueue,
				itemUpdatedQueue,
				itemDeletedQueue);
	}

	@Bean
	public Declarables ex() {
		TopicExchange itemTopicExchange = new TopicExchange("item-topic-exchange");

		return new Declarables(
				itemTopicExchange);
	}

	@Bean
	public Declarables bd() {
		Binding itemCreatedBinding = new Binding("item-created-queue", Binding.DestinationType.QUEUE,"item-topic-exchange","item.created", null);
		Binding itemReadBinding = new Binding("item-read-queue", Binding.DestinationType.QUEUE,"item-topic-exchange","item.read", null);
		Binding itemUpdatedBinding = new Binding("item-updated-queue", Binding.DestinationType.QUEUE,"item-topic-exchange","item.updated", null);
		Binding itemDeletedBinding = new Binding("item-deleted-queue", Binding.DestinationType.QUEUE,"item-topic-exchange","item.deleted", null);

		return new Declarables(
				itemCreatedBinding,
				itemReadBinding,
				itemUpdatedBinding,
				itemDeletedBinding);
	}

	@Bean
	public ItemController server() {
		return new ItemController();
	}

	public static void main(String[] args) {
		SpringApplication.run(ItemPersistenceServiceApplication.class, args);
	}
}
