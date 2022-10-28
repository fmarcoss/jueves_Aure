package com.nttdata.bootcamp.app.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.nttdata.bootcamp.app.domain.Person;

import reactor.core.publisher.Flux;

@Service
public class PersonService {

	public Flux<Person> allPersons() {

		Flux<Person> persons1 = WebClient.create("http://localhost:8080/person-list-1").get().retrieve().bodyToFlux(Person.class);
		Flux<Person> persons2 = WebClient.create("http://localhost:8080/person-list-2").get().retrieve().bodyToFlux(Person.class);
		Flux<Person> persons3 = WebClient.create("http://localhost:8080/person-list-3").get().retrieve().bodyToFlux(Person.class);
		Flux<Person> persons4 = WebClient.create("http://localhost:8080/person-list-4").get().retrieve().bodyToFlux(Person.class);

		Flux<Person> allPersons = Flux.merge(persons1, persons2, persons3, persons4);

		return allPersons;
	}
}
