package nl.groenier.labelbusinessservice.controllers;

import com.google.gson.Gson;
import nl.groenier.labelbusinessservice.models.Item;
import nl.groenier.labelbusinessservice.models.Label;
import nl.groenier.labelbusinessservice.models.Location;
import nl.groenier.labelbusinessservice.services.ItemService;
import nl.groenier.labelbusinessservice.services.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

public class LabelBusinessController {

	private final Logger logger = LoggerFactory.getLogger(LabelBusinessController.class);

	private Gson gson;

	@Autowired
	private ItemService itemService;

	@Autowired
	private LocationService locationService;

	public LabelBusinessController() {
		gson =  new Gson();
	}

	@RabbitListener(queues = "label-read-queue")
	public String readLabel(int id) {
		logger.info("Message read from label-read-queue");

		String replyFromItemService = itemService.requestReplyItem(id);
		Item receivedItem = gson.fromJson(replyFromItemService,Item.class);

		String originJson = locationService.requestReplyLocation(0);
		Location origin = gson.fromJson(originJson, Location.class);

		String destinationJson = locationService.requestReplyLocation(1);
		Location destination = gson.fromJson(destinationJson, Location.class);

		Label label = new Label(receivedItem, origin, destination);

		String replyToClient = gson.toJson(label, Label.class);

		logger.info("received deserialized Item: " + receivedItem);

		return replyToClient;
	}

}
