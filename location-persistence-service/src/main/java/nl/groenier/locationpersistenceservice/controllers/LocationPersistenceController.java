package nl.groenier.locationpersistenceservice.controllers;

import com.google.gson.Gson;
import nl.groenier.locationpersistenceservice.models.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

public class LocationPersistenceController {

	private final Logger logger = LoggerFactory.getLogger(LocationPersistenceController.class);

	private Gson gson;

	@Autowired
	private LocationPersistenceController locationPersistenceServiceImpl;

	public LocationPersistenceController() {
		gson = new Gson();
	}

	@RabbitListener(queues = "item-read-queue")
	public String read(Integer id) {
		logger.info("Message retrieved from item-read-queue");
		String requestedLocation = locationPersistenceServiceImpl.read(id);
		logger.debug("requested item: " + requestedLocation);
		String json = gson.toJson(requestedLocation);
		logger.info("Returning result");
		return json;
	}

	@RabbitListener(queues = "item-created-queue")
	public String create(Location locationToCreate) {
		logger.info("Message read from item-created-queue");
//		String json = gson.toJson(db.getItem(id));
		locationPersistenceServiceImpl.create(locationToCreate);
		String json = "ha";
		logger.info("Returning result");
		return json;
	}

}
