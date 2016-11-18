package br.ufsc.grad.renatoback.tcc.loyalty.service.rest;

import java.util.Date;

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
	LoyaltyService service;

	@RequestMapping(path = "/{time}", method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void send(@PathVariable("time") Long time) {
		service.createBalance(time);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseStatus(code = HttpStatus.OK)
	public void resetStatistics() {
		service.resetStatistics();
	}

	@ResponseStatus(code = HttpStatus.OK)
	@RequestMapping(path = "/{threads}/{sleep}", method = RequestMethod.PUT)
	public void printStatistics(@PathVariable("threads") Integer threads, @PathVariable("sleep") Integer sleep) {
		service.printStatistics(threads, sleep);
	}

	@RequestMapping(method = RequestMethod.OPTIONS)
	@ResponseStatus(code = HttpStatus.OK)
	public void printTime() {
		System.out.println("Nano time: " + new Date().getTime());
	}

	@ResponseStatus(code = HttpStatus.OK)
	@RequestMapping(path = "/sync/{time}", method = RequestMethod.PUT)
	public void syncTime(@PathVariable("time") Long time) {
		service.syncTime(time);
	}

}
