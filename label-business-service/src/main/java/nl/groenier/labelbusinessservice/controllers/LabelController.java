package nl.groenier.labelbusinessservice.controllers;

import com.google.gson.Gson;
import nl.groenier.labelbusinessservice.models.Item;
import nl.groenier.labelbusinessservice.services.ItemService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

public class LabelController {

	private Gson gson;

	@Autowired
	private ItemService itemService;

	public LabelController() {
		gson =  new Gson();
	}

	@RabbitListener(queues = "label-read-queue")
	public String readLabel(int id) {
		System.out.println("Label Business Service --- Label requested!");

		String reply = itemService.requestReplyLabel(id);

		System.out.println(reply);

		Item receivedItem = gson.fromJson(reply,Item.class);

		System.out.println(receivedItem);

		return reply;
	}

}
