package nl.groenier.locationpersistenceservice.config;

import nl.groenier.locationpersistenceservice.controllers.LocationPersistenceController;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	//TODO: Write some configuration.

	@Bean
	public Declarables qs() {
		Queue locationCreatedQueue = new Queue("location-created-queue", false);
		Queue locationReadQueue = new Queue("location-read-queue", false);
		Queue locationUpdatedQueue = new Queue("location-updated-queue", false);
		Queue locationDeletedQueue = new Queue("location-deleted-queue", false);

		Queue locationReadReplyQueue = new Queue("location-read-reply-queue", false);

		return new Declarables(
				locationCreatedQueue,
				locationReadQueue,
				locationUpdatedQueue,
				locationDeletedQueue,
				locationReadReplyQueue);
	}

	@Bean
	public Declarables ex() {
		TopicExchange locationTopicExchange = new TopicExchange("location-topic-exchange");

		return new Declarables(locationTopicExchange);
	}

	@Bean
	public Declarables bd() {
		Binding locationCreatedBinding = new Binding("location-created-queue", Binding.DestinationType.QUEUE,"location-topic-exchange","location.created", null);
		Binding locationReadBinding = new Binding("location-read-queue", Binding.DestinationType.QUEUE,"location-topic-exchange","location.read", null);
		Binding locationUpdatedBinding = new Binding("location-updated-queue", Binding.DestinationType.QUEUE,"location-topic-exchange","location.updated", null);
		Binding locationDeletedBinding = new Binding("location-deleted-queue", Binding.DestinationType.QUEUE,"location-topic-exchange","location.deleted", null);
		Binding locationReadReplyBinding = new Binding("location-read-reply-queue", Binding.DestinationType.QUEUE,"location-topic-exchange","location.read.reply", null);

		return new Declarables(
				locationCreatedBinding,
				locationReadBinding,
				locationUpdatedBinding,
				locationDeletedBinding,
				locationReadReplyBinding);
	}

	@Bean
	public LocationPersistenceController locationPersistenceController() {return new LocationPersistenceController(); }

}
