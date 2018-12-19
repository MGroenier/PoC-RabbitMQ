package nl.groenier.gatewayservice.controllers;

import nl.groenier.gatewayservice.GatewayServiceApplication;
import nl.groenier.gatewayservice.services.LabelService;
import nl.groenier.gatewayservice.services.LabelServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class GatewayController {

	private final Logger logger = LoggerFactory.getLogger(GatewayController.class);

	@Autowired
	private LabelService labelService;

	@GetMapping("/label")
	@ResponseBody
	public String readLabel(@RequestParam(name="item-id") int item_id) {

		logger.info("/label endpoint was called.");

		String response = labelService.requestReplyLabel(item_id);

		return response;
	}

}
