package br.ufsc.grad.renatoback.tcc.loyalty.service.rest;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service
public class LoyaltyService {

	private Log logger = LogFactory.getLog(LoyaltyService.class);

	AtomicInteger counter = new AtomicInteger();
	AtomicLong average = new AtomicLong();

	public void createBalance(Long time) {
		counter.incrementAndGet();
		average.accumulateAndGet(new Date().getTime() - time, (n, m) -> (n + m) / (n == 0 || m == 0 ? 1 : 2));
	}

	public void printStatistics(Integer threads, Integer sleep) {
		logger.info(String.format("LOYALTY [%d threads][%d sleep] - [%d packages][%d average ms]", threads, sleep,
				counter.get(), average.get()));
	}

	public void resetStatistics() {
		counter.set(0);
		average.set(0);
	}

}
