package nl.groenier.itempersistenceservice.config;

import nl.groenier.itempersistenceservice.controllers.ItemController;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

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
	public ItemController itemController() {
		return new ItemController();
	}

}
