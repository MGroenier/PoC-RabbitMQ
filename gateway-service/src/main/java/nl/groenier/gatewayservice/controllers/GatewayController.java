package nl.groenier.gatewayservice.controllers;

import nl.groenier.gatewayservice.services.LabelService;
import nl.groenier.gatewayservice.services.LabelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GatewayController {

	@Autowired
	private LabelService labelService;

	@GetMapping("/label")
	@ResponseBody
	public String readLabel(@RequestParam(name="item-id") int item_id) {

		// This endpoint should eventually request the "Label Business Service" for the label of the item
		// with the passed item_id.	Using a Request/Reply pattern..?

		String response = labelService.requestReplyLabel(item_id);

		return response;
	}

}
