package nl.groenier.labelbusinessservice.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService{

	private RabbitTemplate rabbitTemplate;

	@Autowired
	public ItemServiceImpl(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	@Override
	public String requestReplyLabel(int id) {
		System.out.println("sending message: " + id);
		String response = (String) rabbitTemplate.convertSendAndReceive("item-topic-exchange", "item.read", id);
		System.out.println("Received reply is: " + response);
		return response;
	}

	@Override
	public String requestReplyItem(int id) {
		System.out.println("sending message: " + id);
		String response = (String) rabbitTemplate.convertSendAndReceive("spring-boot-direct-exchange-b", "queue-b", id);
		System.out.println("Received reply is: " + response);
		return response;
	}
}
