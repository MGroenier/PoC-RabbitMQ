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

	public static void main(String[] args) {
		SpringApplication.run(ItemPersistenceServiceApplication.class, args);
	}
}
