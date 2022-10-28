package com.nttdata.bootcamp.server.web;

import java.time.Duration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcamp.server.domain.Person;

import reactor.core.publisher.Flux;

@RestController
public class PersonListController {

	@GetMapping("/person-list-1")
	public Flux<Person> personList1() {

		Flux<Person> lista = Flux.just(new Person("Fran", "Marcos", 31), new Person("Pepe", "Trillo", 35))
				.delaySequence(Duration.ofSeconds(10));

		return lista;
	}

	@GetMapping("/person-list-2")
	public Flux<Person> personList2() {

		Flux<Person> lista = Flux.just(new Person("A", "B", 12), new Person("C", "D", 14))
				.delaySequence(Duration.ofSeconds(10));

		return lista;
	}

	@GetMapping("/person-list-3")
	public Flux<Person> personList3() {

		Flux<Person> lista = Flux.just(new Person("Laura", "Morales", 30), new Person("Jose", "Algo", 50))
				.delaySequence(Duration.ofSeconds(10));

		return lista;
	}

	@GetMapping("/person-list-4")
	public Flux<Person> personList4() {

		Flux<Person> lista = Flux.just(new Person("Miry", "Carranza", 29), new Person("Beatriz", "Sanchez", 23))
				.delaySequence(Duration.ofSeconds(10));

		return lista;
	}
}
