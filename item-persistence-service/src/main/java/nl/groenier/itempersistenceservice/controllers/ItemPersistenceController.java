package nl.groenier.itempersistenceservice.controllers;

import com.google.gson.Gson;
import nl.groenier.itempersistenceservice.models.Item;
import nl.groenier.itempersistenceservice.services.ItemPersistenceServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ItemPersistenceController {

	private final Logger logger = LoggerFactory.getLogger(ItemPersistenceController.class);

	private Gson gson;

	@Autowired
	private ItemPersistenceServiceImpl itemPersistenceServiceImpl;

	public ItemPersistenceController() {
		gson = new Gson();
	}

	@RabbitListener(queues = "item-read-queue")
	public String read(Integer id) {
		logger.info("Message retrieved from item-read-queue");
		Item requestedItem = itemPersistenceServiceImpl.read(id);
		logger.debug("requested item: " + requestedItem);
		String json = gson.toJson(requestedItem);
		logger.info("Returning result");
		return json;
	}

	@RabbitListener(queues = "item-created-queue")
	public String create(Item itemToCreate) {
		logger.info("Message read from item-created-queue");
//		String json = gson.toJson(db.getItem(id));
		itemPersistenceServiceImpl.create(itemToCreate);
		String json = "ha";
		logger.info("Returning result");
		return json;
	}

}
