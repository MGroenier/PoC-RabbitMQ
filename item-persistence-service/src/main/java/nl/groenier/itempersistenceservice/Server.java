package nl.groenier.itempersistenceservice;

import com.google.gson.Gson;
import nl.groenier.itempersistenceservice.models.Item;
import nl.groenier.itempersistenceservice.persistence.Database;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class Server {

	private Database db;
	private Gson gson;

	public Server() {
		db = new Database();
		gson = new Gson();
	}

	@RabbitListener(queues = "queue-b")
	public String something(int id) {
		System.out.println("Item Persistence Service --- Received a message!");
		String json = gson.toJson(db.getItem(id));
		return json;
	}

}
