package com.nttdata.bootcamp.reactor.practices.exercise1;

import reactor.core.publisher.Flux;

public class Exercise1 {

	public static void main(String[] args) {
		Flux<String> messageSender = Flux.just("Mensaje 1", "Mensaje 2", "Mensaje 3");

		messageSender.subscribe(x -> System.out.println("Consumer 1. Received: " + x),
				e -> System.out.println("Consumer 1. Error: " + e.getMessage()),
				() -> System.out.println("Consumer 1. Completed"));

		messageSender.subscribe(y -> System.out.println("Consumer 2. Received: " + y),
				e -> System.out.println("Consumer 2. Error: " + e.getMessage()),
				() -> System.out.println("Consumer 2. Completed"));
	}
}
