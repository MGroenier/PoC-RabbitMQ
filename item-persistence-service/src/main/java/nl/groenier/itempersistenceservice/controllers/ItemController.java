package nl.groenier.itempersistenceservice.controllers;

import com.google.gson.Gson;
import nl.groenier.itempersistenceservice.models.Item;
import nl.groenier.itempersistenceservice.persistence.Database;
import nl.groenier.itempersistenceservice.persistence.ItemRepository;
import nl.groenier.itempersistenceservice.services.ItemService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemController {

	private Gson gson;

	@Autowired
	private ItemService itemService;

	public ItemController() {
		gson = new Gson();
	}

	@RabbitListener(queues = "item-created-queue")
	public String create(Item itemToCreate) {
		System.out.println("Item Persistence Service --- Received a CREATE message!");
//		String json = gson.toJson(db.getItem(id));
		itemService.create(itemToCreate);
		String json = "ha";
		return json;
	}

	@RabbitListener(queues = "item-read-queue")
	public String read(Integer id) {
		System.out.println("Item Persistence Service --- Received a READ message!");
		String json = gson.toJson(itemService.read(id));
		return json;
	}

}
