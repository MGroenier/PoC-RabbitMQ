package nl.groenier.itempersistenceservice;

import nl.groenier.itempersistenceservice.controllers.ItemController;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ItemPersistenceServiceApplication {

//	@Bean
//	Queue queue() {
//		return new Queue("queue-b", false);
//	}
//
//	@Bean
//	DirectExchange exchange() {
//		return new DirectExchange("spring-boot-direct-exchange-b");
//	}
//
//	@Bean
//	Binding binding(Queue queue, DirectExchange exchange) {
//		return BindingBuilder.bind(queue).to(exchange).with("queue-b");
//	}

	@Bean
	public ItemController server() {
		return new ItemController();
	}

	public static void main(String[] args) {
		SpringApplication.run(ItemPersistenceServiceApplication.class, args);
	}
}
