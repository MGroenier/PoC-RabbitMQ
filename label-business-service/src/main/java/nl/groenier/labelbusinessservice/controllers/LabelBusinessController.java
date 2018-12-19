package nl.groenier.labelbusinessservice.controllers;

import com.google.gson.Gson;
import nl.groenier.labelbusinessservice.models.Item;
import nl.groenier.labelbusinessservice.models.Label;
import nl.groenier.labelbusinessservice.services.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

public class LabelBusinessController {

	private final Logger logger = LoggerFactory.getLogger(LabelBusinessController.class);

	private Gson gson;

	@Autowired
	private ItemService itemService;

	public LabelBusinessController() {
		gson =  new Gson();
	}

	@RabbitListener(queues = "label-read-queue")
	public String readLabel(int id) {
		logger.info("Message read from label-read-queue");

		String replyFromServer = itemService.requestReplyLabel(id);

		logger.debug("Read message: " + replyFromServer);

		Item receivedItem = gson.fromJson(replyFromServer,Item.class);

		Label label = new Label(receivedItem);
		String replyToClient = gson.toJson(label, Label.class);

		logger.info("received deserialized Item: " + receivedItem);

		return replyToClient;
	}

}
