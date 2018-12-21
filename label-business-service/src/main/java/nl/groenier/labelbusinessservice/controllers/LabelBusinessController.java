package nl.groenier.labelbusinessservice.controllers;

import com.google.gson.Gson;
import nl.groenier.labelbusinessservice.models.Item;
import nl.groenier.labelbusinessservice.models.Label;
import nl.groenier.labelbusinessservice.models.Location;
import nl.groenier.labelbusinessservice.services.ItemService;
import nl.groenier.labelbusinessservice.services.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ExecutionException;

public class LabelBusinessController {

	private final Logger logger = LoggerFactory.getLogger(LabelBusinessController.class);

	private Gson gson;

	@Autowired
	private ItemService itemService;

	@Autowired
	private LocationService locationService;

//	@Autowired
//	private RabbitTemplate rabbitTemplate;

	@Autowired
	private AsyncRabbitTemplate asyncRabbitTemplate;

	@Autowired
	public LabelBusinessController() {
//		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(rabbitTemplate.getConnectionFactory());
//		container.setQueueNames("location-read-reply-queue");
//		this.asyncRabbitTemplate = new AsyncRabbitTemplate(rabbitTemplate, container);
//		asyncRabbitTemplate.start();

		gson =  new Gson();
	}

//	@RabbitListener(queues = "label-read-queue")
//	public String readLabel(int id) {
//		logger.info("Message read from label-read-queue");
//
//		String replyFromItemService = itemService.requestReplyItem(id);
//		Item receivedItem = gson.fromJson(replyFromItemService,Item.class);
//
//		String originJson = locationService.requestReplyLocation(receivedItem.getOrigin());
//		Location origin = gson.fromJson(originJson, Location.class);
//
//		String destinationJson = locationService.requestReplyLocation(receivedItem.getDestination());
//		Location destination = gson.fromJson(destinationJson, Location.class);
//
//		Label label = new Label(receivedItem, origin, destination);
//
//		String replyToClient = gson.toJson(label, Label.class);
//
//		logger.info("received deserialized Item: " + receivedItem);
//
//		return replyToClient;
//	}

	@RabbitListener(queues = "label-read-queue")
	public String readLabelASync(int id) {
		String replyFromItemService = itemService.requestReplyItem(id);
		Item receivedItem = gson.fromJson(replyFromItemService,Item.class);

		AsyncRabbitTemplate.RabbitConverterFuture<String> future_origin = asyncRabbitTemplate.convertSendAndReceive("location-topic-exchange", "location.read", receivedItem.getOrigin());
		AsyncRabbitTemplate.RabbitConverterFuture<String> future_destination = asyncRabbitTemplate.convertSendAndReceive("location-topic-exchange", "location.read", receivedItem.getDestination());

		String reply_origin = null;
		String reply_destination = null;

		try {
			reply_origin = future_origin.get();
			reply_destination = future_destination.get();

			System.out.println("async origin reply: " + reply_origin);
			System.out.println("async destination reply: " + reply_destination);
		}
		catch (ExecutionException e) {
			logger.error("readLabelASync failed!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Location origin = gson.fromJson(reply_origin, Location.class);
		Location destination = gson.fromJson(reply_destination, Location.class);

		Label label = new Label(receivedItem, origin, destination);

		String replyToClient = gson.toJson(label, Label.class);

		return replyToClient;
	}

}
