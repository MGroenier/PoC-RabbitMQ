package nl.groenier.labelbusinessservice.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService{

	private final Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);

	private RabbitTemplate rabbitTemplate;

	@Autowired
	public ItemServiceImpl(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	@Override
	public String requestReplyLabel(int id) {
		logger.info("Sending message to exchange 'item-topic-exchange' with routingKey 'item.read'");
		String response = (String) rabbitTemplate.convertSendAndReceive("item-topic-exchange", "item.read", id);
		logger.info("Received reply: " + response);
		return response;
	}

}
