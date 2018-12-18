package nl.groenier.labelbusinessservice;

import nl.groenier.labelbusinessservice.controllers.LabelController;
import org.springframework.amqp.core.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LabelBusinessServiceApplication {


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
	public LabelController server() {
		return new LabelController();
	}

	public static void main(String[] args) {
		SpringApplication.run(LabelBusinessServiceApplication.class, args);
	}
}
