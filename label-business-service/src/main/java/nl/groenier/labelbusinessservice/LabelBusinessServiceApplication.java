package nl.groenier.labelbusinessservice;

import nl.groenier.labelbusinessservice.controllers.LabelController;
import org.springframework.amqp.core.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LabelBusinessServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabelBusinessServiceApplication.class, args);
	}

}
