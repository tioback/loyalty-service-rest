package br.ufsc.grad.renatoback.tcc.loyalty.service.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoyaltyController {

	@Autowired
	LoyaltyService loyaltyService;

	@RequestMapping(path = "/{time}", method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void send(@PathVariable("time") Long time) {
		loyaltyService.createBalance(time);
	}

}
