package nl.groenier.itempersistenceservice.controllers;

import com.google.gson.Gson;
import nl.groenier.itempersistenceservice.models.Item;
import nl.groenier.itempersistenceservice.services.ItemPersistenceServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemController {

	private Gson gson;

	@Autowired
	private ItemPersistenceServiceImpl itemPersistenceServiceImpl;

	public ItemController() {
		gson = new Gson();
	}

	@RabbitListener(queues = "item-created-queue")
	public String create(Item itemToCreate) {
		System.out.println("Item Persistence Service --- Received a CREATE message!");
//		String json = gson.toJson(db.getItem(id));
		itemPersistenceServiceImpl.create(itemToCreate);
		String json = "ha";
		return json;
	}

	@RabbitListener(queues = "item-read-queue")
	public String read(Integer id) {
		System.out.println("Item Persistence Service --- Received a READ message!");
		String json = gson.toJson(itemPersistenceServiceImpl.read(id));
		return json;
	}

}
