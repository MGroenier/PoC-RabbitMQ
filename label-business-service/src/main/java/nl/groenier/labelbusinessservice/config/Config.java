package nl.groenier.labelbusinessservice.config;

import nl.groenier.labelbusinessservice.controllers.LabelBusinessController;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private ConnectionFactory connectionFactory;

	@Bean
	public Declarables qs() {
		Queue labelReadQueue = new Queue("label-read-queue", false);
		return new Declarables(labelReadQueue);
	}

	@Bean
	public Declarables ex() {
		TopicExchange labelTopicExchange = new TopicExchange("label-topic-exchange");
		return new Declarables(labelTopicExchange);
	}

	@Bean
	public Declarables bd() {
		Binding labelReadBinding = new Binding("label-read-queue", Binding.DestinationType.QUEUE,"label-topic-exchange","label.read", null);
		return new Declarables(labelReadBinding);
	}

	@Bean
	public LabelBusinessController labelController() {
		return new LabelBusinessController();
	}

	@Bean
	public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		return rabbitTemplate;
	}

	@Bean
	AsyncRabbitTemplate template() {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
		container.setQueueNames("location-read-reply-queue");
		return new AsyncRabbitTemplate(rabbitTemplate, container);
	}

}
