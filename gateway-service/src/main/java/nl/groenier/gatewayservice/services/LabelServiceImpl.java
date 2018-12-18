package nl.groenier.gatewayservice.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabelServiceImpl implements LabelService {

	private RabbitTemplate rabbitTemplate;

	@Autowired
	public LabelServiceImpl(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	@Override
	public String requestReplyLabel(int id) {
		System.out.println("sending message: " + id);
		String response = (String) rabbitTemplate.convertSendAndReceive("label-topic-exchange", "label.read", id);
		System.out.println("Received reply is: " + response);
		return response;
	}

}
