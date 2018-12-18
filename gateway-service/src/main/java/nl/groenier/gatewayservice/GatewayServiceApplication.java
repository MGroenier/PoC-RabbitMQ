package nl.groenier.gatewayservice;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceApplication {

//	@Bean
//	Binding binding(Queue queue, DirectExchange exchange) {
//		return BindingBuilder.bind(queue).to(exchange).with("queue-b");
//	}
//
//	@Bean
//	Queue queue2() {
//		return new Queue("queue-a", false);
//	}
//
//	@Bean
//	DirectExchange exchange2() {
//		return new DirectExchange("spring-boot-direct-exchange");
//	}
//
//	@Bean
//	Binding binding2(Queue queue, DirectExchange exchange) {
//		return BindingBuilder.bind(queue).to(exchange).with("queue-a");
//	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}
}
