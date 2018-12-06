package nl.groenier.labelbusinessservice;

import nl.groenier.itempersistenceservice.models.Item;
import nl.groenier.labelbusinessservice.services.ItemService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

public class Server {

	@Autowired
	private ItemService itemService;

	@RabbitListener(queues = "queue-a")
	public String something(int id) {
		System.out.println("Label Business Service --- Received a message!");

		String reply = itemService.requestReplyItem(id);

		return reply;
	}

}
