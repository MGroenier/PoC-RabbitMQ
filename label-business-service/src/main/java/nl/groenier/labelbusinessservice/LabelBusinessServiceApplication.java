package nl.groenier.labelbusinessservice;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LabelBusinessServiceApplication {

	@Bean
	Queue queue() {
		return new Queue("queue-a", false);
	}

	@Bean
	DirectExchange exchange() {
		return new DirectExchange("spring-boot-direct-exchange");
	}

	@Bean
	Binding binding(Queue queue, DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("queue-a");
	}

	@Bean
	public Server server() {
		return new Server();
	}

	public static void main(String[] args) {
		SpringApplication.run(LabelBusinessServiceApplication.class, args);
	}
}
