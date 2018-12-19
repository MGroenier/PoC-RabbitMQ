package nl.groenier.gatewayservice.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabelServiceImpl implements LabelService {

	private final Logger logger = LoggerFactory.getLogger(LabelServiceImpl.class);

	private RabbitTemplate rabbitTemplate;

	@Autowired
	public LabelServiceImpl(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	@Override
	public String requestReplyLabel(int id) {
		logger.info("Sending message to exchange 'label-topic-exchange' with routingKey 'label.read'");
		String response = (String) rabbitTemplate.convertSendAndReceive("label-topic-exchange", "label.read", id);
		logger.info("Received reply: " + response);
		return response;
	}

}
