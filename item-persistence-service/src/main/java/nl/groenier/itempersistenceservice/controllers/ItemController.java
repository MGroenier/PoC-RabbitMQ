package nl.groenier.itempersistenceservice.controllers;

import com.google.gson.Gson;
import nl.groenier.itempersistenceservice.models.Item;
import nl.groenier.itempersistenceservice.persistence.Database;
import nl.groenier.itempersistenceservice.persistence.ItemRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemController {

	private Database db;
	private Gson gson;

	public ItemController() {
		db = new Database();
		gson = new Gson();
	}

	@RabbitListener(queues = "queue-b")
	public String read(int id) {
		System.out.println("Item Persistence Service --- Received a message!");
//		String json = gson.toJson(db.getItem(id));
		String json = "ha";
		return json;
	}

	@RabbitListener(queues = "queue-b")
	public String readAll(int id) {
		System.out.println("Item Persistence Service --- readAll()");
//		String json = gson.toJson(db.getItem(id));
		String json = "ha";
		return json;
	}

}
