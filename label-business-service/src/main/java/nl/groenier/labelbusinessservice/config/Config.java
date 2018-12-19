package nl.groenier.labelbusinessservice.config;

import nl.groenier.labelbusinessservice.controllers.LabelController;
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

		Queue labelReadQueue = new Queue("label-read-queue", false);

		return new Declarables(
				labelReadQueue);
	}

	@Bean
	public Declarables ex() {
		TopicExchange labelTopicExchange = new TopicExchange("label-topic-exchange");

		return new Declarables(
				labelTopicExchange);
	}

	@Bean
	public Declarables bd() {
		Binding labelReadBinding = new Binding("label-read-queue", Binding.DestinationType.QUEUE,"label-topic-exchange","label.read", null);

		return new Declarables(
				labelReadBinding);
	}

	@Bean
	public LabelController labelController() {
		return new LabelController();
	}

}
